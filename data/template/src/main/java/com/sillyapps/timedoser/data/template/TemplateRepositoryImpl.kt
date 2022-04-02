package com.sillyapps.timedoser.data.template

import com.sillyapps.core.di.IODispatcher
import com.sillyapps.timedoser.data.template.model.TemplateDataModel
import com.sillyapps.timedoser.data.template.model.toDataModel
import com.sillyapps.timedoser.data.template.model.toDomainModel
import com.sillyapps.timedoser.data.template.persistence.TemplateDao
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.domain.template.model.Template
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TemplateRepositoryImpl @Inject constructor(
  private val defaultTemplateDataSource: DefaultTemplateDataSource,
  private val templateDao: TemplateDao,
  @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : TemplateRepository {
  override fun getAllTemplates(): Flow<List<Template>> =
    templateDao.observeAll().map { templates ->
      templates.map { it.toDomainModel() }
    }

  override suspend fun getDefaultTemplate(): Template? = withContext(ioDispatcher) {
    val templateId = defaultTemplateDataSource.getDefaultTemplateId()

    val template = templateDao.getTemplate(templateId ?: -1)
    if (template != null) return@withContext template.toDomainModel()

    return@withContext setNewDefaultTemplate()?.toDomainModel()
  }

  private suspend fun setNewDefaultTemplate(): TemplateDataModel? {
    val newDefaultTemplate = templateDao.getFirstExistingTemplate()

    if (newDefaultTemplate != null) {
      defaultTemplateDataSource.updateDefaultTemplate(newDefaultTemplate.id)
    }

    return newDefaultTemplate
  }


  override fun getTemplate(id: Long): Flow<Template?> {
    return templateDao.observeOne(id).map { it?.toDomainModel() }
  }

  override suspend fun upsertTemplate(template: Template) = withContext(ioDispatcher) {
    templateDao.upsert(template.toDataModel())
  }

  override suspend fun deleteTemplate(template: Template) = withContext(ioDispatcher) {
    templateDao.delete(template.toDataModel())
  }

}
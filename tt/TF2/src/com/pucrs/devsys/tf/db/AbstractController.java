package com.pucrs.devsys.tf.db;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractController<M extends AbstractModel> {

	private Class<M> modelClass;

	@SuppressWarnings("unchecked")
	public AbstractController() {
		this.modelClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<M> getModelClass() {
		return modelClass;
	}

}

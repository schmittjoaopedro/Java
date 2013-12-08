package comp.cleniduarte.services;

import comp.cleniduarte.commons.JsonBeanEncapsule;

public interface IGenericService {

	public JsonBeanEncapsule save(Object record);
	public JsonBeanEncapsule delete(Long id);
	public JsonBeanEncapsule update(Object record);
	public JsonBeanEncapsule findAll();
	public JsonBeanEncapsule findPaginate(int start, int limit);
	
}

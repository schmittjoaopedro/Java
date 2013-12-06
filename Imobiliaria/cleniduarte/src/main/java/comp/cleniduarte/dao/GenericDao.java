package comp.cleniduarte.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public abstract class GenericDao<PK, T> {

	@Autowired private SessionFactory sessionFactory;
	
	//Implementations...
	protected SessionFactory getSession(){
		return sessionFactory;
	}
	
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return getSession().getCurrentSession().createQuery("from " + getTypeClass().getName()).list();
	}
	
	
	@Transactional
	public void save(Object t){
		getSession().getCurrentSession().persist(t);
	}
	
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public T getSingle(Long id){
		return (T) getSession().getCurrentSession().get(getTypeClass(),id);
				
	}
	
	
	@Transactional
	public void delete(Long id){
		T record = this.getSingle(id);
		getSession().getCurrentSession().delete(record);
	}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<T> getPaginationData(int start, int limit){
		Criteria criteriaPagination = getSession().getCurrentSession().createCriteria(getTypeClass());
		criteriaPagination.setFirstResult(start);
		criteriaPagination.setMaxResults(limit);
		return criteriaPagination.list();
	}
	
	
	@Transactional
	public Long count(){
		Criteria criteriaCount = getSession().getCurrentSession().createCriteria(getTypeClass());
		return (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	
	@Transactional
	public void update(Object record){
		getSession().getCurrentSession().update(record);
	}
	
	//Method for get type class extended this class
	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
	                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
	
}

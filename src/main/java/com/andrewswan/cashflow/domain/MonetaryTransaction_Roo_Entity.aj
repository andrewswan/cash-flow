package com.andrewswan.cashflow.domain;

import com.andrewswan.cashflow.domain.MonetaryTransaction;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect MonetaryTransaction_Roo_Entity {
    
    @PersistenceContext    
    transient EntityManager MonetaryTransaction.entityManager;    
    
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name = "id")    
    private Long MonetaryTransaction.id;    
    
    @Version    
    @Column(name = "version")    
    private Integer MonetaryTransaction.version;    
    
    public Long MonetaryTransaction.getId() {    
        return this.id;        
    }    
    
    public void MonetaryTransaction.setId(Long id) {    
        this.id = id;        
    }    
    
    public Integer MonetaryTransaction.getVersion() {    
        return this.version;        
    }    
    
    public void MonetaryTransaction.setVersion(Integer version) {    
        this.version = version;        
    }    
    
    @Transactional    
    public void MonetaryTransaction.persist() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        this.entityManager.persist(this);        
    }    
    
    @Transactional    
    public void MonetaryTransaction.remove() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        if (this.entityManager.contains(this)) {        
            this.entityManager.remove(this);            
        } else {        
            MonetaryTransaction attached = this.entityManager.find(MonetaryTransaction.class, this.id);            
            this.entityManager.remove(attached);            
        }        
    }    
    
    @Transactional    
    public void MonetaryTransaction.flush() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        this.entityManager.flush();        
    }    
    
    @Transactional    
    public void MonetaryTransaction.merge() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        MonetaryTransaction merged = this.entityManager.merge(this);        
        this.entityManager.flush();        
        this.id = merged.getId();        
    }    
    
    public static final EntityManager MonetaryTransaction.entityManager() {    
        EntityManager em = new MonetaryTransaction().entityManager;        
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");        
        return em;        
    }    
    
    public static long MonetaryTransaction.countMonetaryTransactions() {    
        return (Long) entityManager().createQuery("select count(o) from MonetaryTransaction o").getSingleResult();        
    }    
    
    public static List<MonetaryTransaction> MonetaryTransaction.findAllMonetaryTransactions() {    
        return entityManager().createQuery("select o from MonetaryTransaction o").getResultList();        
    }    
    
    public static MonetaryTransaction MonetaryTransaction.findMonetaryTransaction(Long id) {    
        if (id == null) throw new IllegalArgumentException("An identifier is required to retrieve an instance of MonetaryTransaction");        
        return entityManager().find(MonetaryTransaction.class, id);        
    }    
    
    public static List<MonetaryTransaction> MonetaryTransaction.findMonetaryTransactionEntries(int firstResult, int maxResults) {    
        return entityManager().createQuery("select o from MonetaryTransaction o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();        
    }    
    
}

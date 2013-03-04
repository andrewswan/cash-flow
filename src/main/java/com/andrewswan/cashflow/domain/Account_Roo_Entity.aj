package com.andrewswan.cashflow.domain;

import com.andrewswan.cashflow.domain.Account;
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

privileged aspect Account_Roo_Entity {
    
    @PersistenceContext    
    transient EntityManager Account.entityManager;    
    
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name = "id")    
    private Long Account.id;    
    
    @Version    
    @Column(name = "version")    
    private Integer Account.version;    
    
    public Long Account.getId() {    
        return this.id;        
    }    
    
    public void Account.setId(Long id) {    
        this.id = id;        
    }    
    
    public Integer Account.getVersion() {    
        return this.version;        
    }    
    
    public void Account.setVersion(Integer version) {    
        this.version = version;        
    }    
    
    @Transactional    
    public void Account.persist() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        this.entityManager.persist(this);        
    }    
    
    @Transactional    
    public void Account.remove() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        if (this.entityManager.contains(this)) {        
            this.entityManager.remove(this);            
        } else {        
            Account attached = this.entityManager.find(Account.class, this.id);            
            this.entityManager.remove(attached);            
        }        
    }    
    
    @Transactional    
    public void Account.flush() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        this.entityManager.flush();        
    }    
    
    @Transactional    
    public void Account.merge() {    
        if (this.entityManager == null) this.entityManager = entityManager();        
        Account merged = this.entityManager.merge(this);        
        this.entityManager.flush();        
        this.id = merged.getId();        
    }    
    
    public static final EntityManager Account.entityManager() {    
        EntityManager em = new Account().entityManager;        
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");        
        return em;        
    }    
    
    public static long Account.countAccounts() {    
        return (Long) entityManager().createQuery("select count(o) from Account o").getSingleResult();        
    }    
    
    public static List<Account> Account.findAllAccounts() {    
        return entityManager().createQuery("select o from Account o").getResultList();        
    }    
    
    public static Account Account.findAccount(Long id) {    
        if (id == null) throw new IllegalArgumentException("An identifier is required to retrieve an instance of Account");        
        return entityManager().find(Account.class, id);        
    }    
    
    public static List<Account> Account.findAccountEntries(int firstResult, int maxResults) {    
        return entityManager().createQuery("select o from Account o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();        
    }    
    
}

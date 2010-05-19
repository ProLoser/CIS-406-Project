/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Owner
 */
@Entity
@Table(name = "TERM", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Term.findAll", query = "SELECT t FROM Term t"),
    @NamedQuery(name = "Term.findByQuarter", query = "SELECT t FROM Term t WHERE t.quarter = :quarter"),
    @NamedQuery(name = "Term.findByTermId", query = "SELECT t FROM Term t WHERE t.termId = :termId"),
    @NamedQuery(name = "Term.findByTermYear", query = "SELECT t FROM Term t WHERE t.termYear = :termYear")})
public class Term implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "QUARTER")
    private String quarter;
    @Id
    @Basic(optional = false)
    @Column(name = "TERM_ID")
    private Integer termId;
    @Column(name = "TERM_YEAR")
    private Short termYear;

    public Term() {
    }

    public Term(Integer termId) {
        this.termId = termId;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        String oldQuarter = this.quarter;
        this.quarter = quarter;
        changeSupport.firePropertyChange("quarter", oldQuarter, quarter);
    }

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        Integer oldTermId = this.termId;
        this.termId = termId;
        changeSupport.firePropertyChange("termId", oldTermId, termId);
    }

    public Short getTermYear() {
        return termYear;
    }

    public void setTermYear(Short termYear) {
        Short oldTermYear = this.termYear;
        this.termYear = termYear;
        changeSupport.firePropertyChange("termYear", oldTermYear, termYear);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termId != null ? termId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Term)) {
            return false;
        }
        Term other = (Term) object;
        if ((this.termId == null && other.termId != null) || (this.termId != null && !this.termId.equals(other.termId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cis406.Term[termId=" + termId + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}

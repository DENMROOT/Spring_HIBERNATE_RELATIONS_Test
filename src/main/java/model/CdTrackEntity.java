package model;

import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by dmakarov on 10/1/2015.
 */
@Entity
@Table(name = "CDTRACK")
public class CdTrackEntity {
    @Id
    @GeneratedValue
    @Column(name = "CDTRACKID")
    private Long id;

    @Column (name = "TITLE")
    private String title = "Yellow Submarine";

    /* Bidirectional One-to-Many with new field CDDISK_ID - see also CdDiskEntity
    @ManyToOne
    @JoinColumn(name="CDDISK_ID")
     */

    @ManyToOne
    private CdDiskEntity cdDisk;

    public CdTrackEntity() {
    }

    public CdTrackEntity(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CdDiskEntity getCdDisk() {
        return cdDisk;
    }

    public void setCdDisk(CdDiskEntity cdDisk) {
        this.cdDisk = cdDisk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CdTrackEntity that = (CdTrackEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title);
    }

    @Override
    public String toString() {
        return "CdTrackEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

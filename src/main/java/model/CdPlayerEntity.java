package model;

import javax.persistence.*;

/**
 * Created by dmakarov on 9/14/2015.
 */
@Entity
@Table(name = "CDPLAYER")
public class CdPlayerEntity {
    @Id
    @Column (name = "CDPLAYERID")
    @GeneratedValue
    private Long id;

    @OneToOne
    private CdDiskEntity disk;

    public CdPlayerEntity() {
    }

    public CdPlayerEntity(CdDiskEntity disk) {
        this.disk = disk;
    }

    public CdDiskEntity getDisk() {
        return disk;
    }

    public void setDisk(CdDiskEntity disk) {
        this.disk = disk;
    }

    public void playDisk() {
        this.disk.play();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

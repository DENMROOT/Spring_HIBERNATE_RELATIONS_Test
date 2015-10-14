package model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dmakarov on 9/14/2015.
 */
@Entity
@Table(name = "CDDISK")
public class CdDiskEntity {
    @Id
    @GeneratedValue
    @Column(name = "CDDISKID", unique = true, nullable = false)
    private Long id;

    @Column (name = "TITLE")
    private String title;

    @Column (name = "ARTIST")
    private String artist;

    /*  Unidirectional with join TABLE
    @OneToMany
    @JoinTable (
            name="CDTRACKS_LINK",
            joinColumns = @JoinColumn( name="CDDISKID"),
            inverseJoinColumns = @JoinColumn( name="CDTRACKID")
    )
     */

    /* Unidirectional with foreign KEY
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="CDDISKID")
     */

    /* Bidirectional with foreign KEY - see also CdTrackEntity
    @OneToMany(mappedBy = "cdDisk")
     */

    @OneToMany
    private List<CdTrackEntity> tracks;

    public CdDiskEntity() {
    }

    public CdDiskEntity(long id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void play() {
        System.out.print(artist + ": " + title);
    }

    public List<CdTrackEntity> getTracks() {
        return tracks;
    }

    public void setTracks(List<CdTrackEntity> tracks) {
        this.tracks = tracks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CdDiskEntity that = (CdDiskEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(title, that.title) &&
                Objects.equal(artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, artist);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("title", title)
                .add("artist", artist)
                .add("tracks", tracks)
                .toString();
    }
}

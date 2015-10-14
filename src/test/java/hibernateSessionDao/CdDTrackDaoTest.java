package hibernateSessionDao;

import config.HibernateSessionConfig;
import model.CdDiskEntity;
import model.CdTrackEntity;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.CdDiskService;
import services.CdTrackService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmakarov on 9/21/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateSessionConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CdDTrackDaoTest {
    private static Logger LOGGER = LoggerFactory.getLogger(CdDTrackDaoTest.class);
    CdDiskEntity cdDisk1 = new CdDiskEntity();

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CdDiskService cdDiskService;

    @Autowired
    private CdTrackService cdTrackService;

    @Before
    public  void Initialize() {
        cdDisk1.setArtist("The Beatles");
        cdDisk1.setTitle("Yellow Submarine");
        cdDiskService.saveCdDisk(cdDisk1);
    }

    @Test
    public void cdDisk3_ShouldBeAddedCorrectly () {

        CdTrackEntity track1 = new CdTrackEntity("Track 1");
        CdTrackEntity track2 = new CdTrackEntity("Track 2");
        cdTrackService.saveCdTrack(track1);
        cdTrackService.saveCdTrack(track2);
        List<CdTrackEntity> tracks = new ArrayList<CdTrackEntity>(Arrays.asList
                (track1, track2));
        cdDiskService.addTrackList(cdDisk1, tracks);
        CdDiskEntity getCddisk = cdDiskService.getFullCdDisk(cdDisk1.getId());

        LOGGER.info(getCddisk.toString());
        assertEquals(cdDisk1, getCddisk);
        assertEquals(cdDisk1.getTracks().get(0).getCdDisk(), track1.getCdDisk());
    }

}

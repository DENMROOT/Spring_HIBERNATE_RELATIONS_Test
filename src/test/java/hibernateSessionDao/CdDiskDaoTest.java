package hibernateSessionDao;

import config.HibernateSessionConfig;
import model.CdDiskEntity;
import model.CdPlayerEntity;
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
import services.CdPlayerService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dmakarov on 9/21/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateSessionConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CdDiskDaoTest {
    private static Logger LOGGER = LoggerFactory.getLogger(CdDTrackDaoTest.class);
    CdDiskEntity cdDisk1 = new CdDiskEntity();
    CdPlayerEntity cdPlayer1 = new CdPlayerEntity();

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CdDiskService cdDiskService;

    @Autowired
    private CdPlayerService cdPlayerService;

    @Before
    public  void Initialize() {
        cdDisk1.setArtist("The Beatles");
        cdDisk1.setTitle("Yellow Submarine");
        cdDiskService.saveCdDisk(cdDisk1);
        cdPlayer1.setDisk(cdDisk1);
        cdPlayerService.saveCdPlayer(cdPlayer1);
    }

    @Test
    public void cdDisk1_ShouldNotBeNull () {
        assertNotNull(cdDisk1);
    }

    @Test
    public void cdPlayer2_ShouldNotBeNull () {
        assertNotNull(cdPlayer1);
    }

    @Test
    public void cdDisk4_ShouldBeUpdatedCorrectly () {
        cdDisk1.setArtist("Mama");
        cdDisk1.setTitle("Mama_Song");
        cdDiskService.saveCdDisk(cdDisk1);

        CdDiskEntity updatedDisk = cdDiskService.getCdDisk(cdDisk1.getId());
        assertEquals(cdDisk1, updatedDisk);
    }

    @Test
    public void cdPlayer5_CdPlayershouldPlayCd () {
        cdDisk1.setArtist("Mama");
        cdDisk1.setTitle("Mama_Song");
        cdDiskService.saveCdDisk(cdDisk1);

        cdPlayerService.saveCdPlayer(cdPlayer1);

        CdPlayerEntity savedPlayer = cdPlayerService.getCdPlayer(cdPlayer1.getId());
        savedPlayer.playDisk();
        assertEquals(cdDisk1, cdPlayer1.getDisk());
    }

}

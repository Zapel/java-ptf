package net.ukr.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class  GeoIpServiceTests {

    @Test
    public void testMyIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("94.154.238.126");
        assertEquals(geoIP.getCountryCode(), "UKR");
    }

    @Test
    public void testInvalidIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("94.154.238.xxx");
        assertEquals(geoIP.getCountryCode(), "UKR");
    }
}

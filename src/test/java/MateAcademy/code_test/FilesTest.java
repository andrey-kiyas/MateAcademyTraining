package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.Test;

public class FilesTest {
    @Test
    public void modifyData_changeEverything() {
        String data = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";
        String program = "Ladder";
        String version = "1.1";
        String expected = "Program: Ladder Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.1";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_programIsTheSame() {
        String data = "Program title: Circular\nAuthor: Dorries\nCorporation: Funny\nPhone: +1-503-555-0095\nDate: Tues July 19, 2014\nVersion: 6.7\nLevel: Release";
        String program = "Circular";
        String version = "1.5";
        String expected = "Program: Circular Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.5";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_authorIsTheSame() {
        String data = "Program title: Circular\nAuthor: g964\nCorporation: Apple\nPhone: +1-503-555-0098\nDate: Tues March 10, 2004\nVersion: 1.5\nLevel: Release";
        String program = "Bicycle";
        String version = "2.0";
        String expected = "Program: Bicycle Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 2.0";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_phoneIsTheSame() {
        String data = "Program title: Bumper\nAuthor: Thorensen\nCorporation: Tyron\nPhone: +1-503-555-0095\nDate: Tues July 19, 2014\nVersion: 1.32\nLevel: Final";
        String program = "Circular";
        String version = "2.2";
        String expected = "Program: Circular Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 2.2";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_dateIsTheSame() {
        String data = "Program title: Balance\nAuthor: Tolkien\nCorporation: IB\nPhone: +1-503-555-0093\nDate: 2019-01-01\nVersion: 4.44\nLevel: Release";
        String program = "Hammer";
        String version = "1.5.6";
        String expected = "Program: Hammer Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.5.6";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_versionIsTheSame() {
        String data = "Program title: Platform\nAuthor: Michael\nCorporation: Gold\nPhone: +1-503-555-0094\nDate: Tues March 10, 2004\nVersion: 10.2\nLevel: Prod";
        String program = "Wheel";
        String version = "10.2";
        String expected = "Program: Wheel Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 10.2";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_versionIs2dot0() {
        String data = "Program title: Car\nAuthor: Arno\nCorporation: Wonder\nPhone: +1-503-555-0097\nDate: Tues March 29, 2017\nVersion: 2.0\nLevel: Final";
        String program = "Wood";
        String version = "2.6";
        String expected = "Program: Wood Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 2.0";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_invalidPhone() {
        String data = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-009\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";
        String program = "Ladder";
        String version = "1.1";
        String expected = "ERROR: VERSION or PHONE";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_versionWithoutDot() {
        String data = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0092\nDate: Tues April 9, 2005\nVersion: 1\nLevel: Alpha";
        String program = "Ladder";
        String version = "1.2";
        String expected = "ERROR: VERSION or PHONE";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_versionWithTwoDots() {
        String data = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0092\nDate: Tues April 9, 2005\nVersion: 1.5.8\nLevel: Alpha";
        String program = "Ladder";
        String version = "1.5.9";
        String expected = "ERROR: VERSION or PHONE";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }

    @Test
    public void modifyData_versionStartingWithDot() {
        String data = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0092\nDate: Tues April 9, 2005\nVersion: .78\nLevel: Alpha";
        String program = "Ladder";
        String version = "1.3";
        String expected = "ERROR: VERSION or PHONE";
        Assert.assertEquals(String.format("Method should return \"%s\" for the input data \n\"%s\", \nprogram \"%s\" and version \"%s\"\n",
                expected, data, program, version), expected, Files.modifyData(data, program, version));
    }
}

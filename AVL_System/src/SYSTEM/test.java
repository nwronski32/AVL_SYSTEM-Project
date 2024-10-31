package SYSTEM;

import SYSTEM.apparatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import SYSTEM.APPARATUS_TYPE;
import SYSTEM.INCIDENT_TYPE;
import SYSTEM.County;
import SYSTEM.mapquestAPI;

public class test {

	public static void main(String[] args) {
		// county
		
		County PG = new County();
		//firehouses
		// Create firehouses with 2 crews, 8xx ID numbers, and their respective addresses
		firehouse hyattsville = new firehouse(801, 2, "6200 Belcrest Road, Hyattsville, MD 20782");
		firehouse collegePark = new firehouse(812, 2, "8115 Baltimore Ave, College Park, MD 20740");
		firehouse greenbelt = new firehouse(835, 2, "125 Crescent Road, Greenbelt, MD 20770");
		firehouse bowie = new firehouse(839, 2, "15454 Annapolis Road, Bowie, MD 20715");
		firehouse laurel = new firehouse(810, 2, "7411 Cherry Lane, Laurel, MD 20707");
		firehouse bladensburg = new firehouse(809, 2, "4213 Edmonston Road, Bladensburg, MD 20710");
		firehouse riverdale = new firehouse(807, 2, "4714 Queensbury Road, Riverdale, MD 20737");
		firehouse berwynHeights = new firehouse(814, 2, "8811 60th Avenue, Berwyn Heights, MD 20740");
		firehouse lanham = new firehouse(848, 2, "7710 Annapolis Road, Lanham, MD 20706");
		firehouse kentland = new firehouse(833, 2, "7500 Glenarden Parkway, Glenarden, MD 20706");
		firehouse oxonHill = new firehouse(842, 2, "1100 Marcy Ave, Oxon Hill, MD 20745");
		firehouse suitland = new firehouse(829, 2, "3207 Forestville Road, Forestville, MD 20747");
		firehouse upperMarlboro = new firehouse(820, 2, "14815 Pratt Street, Upper Marlboro, MD 20772");
		firehouse accokeek = new firehouse(824, 2, "16111 Livingston Road, Accokeek, MD 20607");
		firehouse clinton = new firehouse(825, 2, "9025 Woodyard Road, Clinton, MD 20735");
		firehouse landover = new firehouse(846, 2, "3201 Brightseat Road, Landover, MD 20785");
		firehouse langleypk = new firehouse(834, 2, "7833 Riggs Rd, Adelphi, MD 20783");
		firehouse landoverhills = new firehouse(830,1,"6801 Webster St, Landover Hills, MD 20784");

			
		// Hyattsville Firehouse Apparatus (Station 801)
		apparatus hyattsvilleEngine = new apparatus(801, APPARATUS_TYPE.E);
		apparatus hyattsvilleTruck = new apparatus(801, APPARATUS_TYPE.TK);
		apparatus hyattsvilleSquad = new apparatus(801, APPARATUS_TYPE.RS);
		// College Park Firehouse Apparatus (Station 812)
		apparatus collegeParkEngine = new apparatus(812, APPARATUS_TYPE.E);
		apparatus collegeParkTruck = new apparatus(812, APPARATUS_TYPE.TK);
		// Greenbelt Firehouse Apparatus (Station 835)
		apparatus greenbeltEngine = new apparatus(835, APPARATUS_TYPE.E);
		// Bowie Firehouse Apparatus (Station 839)
		apparatus bowieEngine = new apparatus(839, APPARATUS_TYPE.E);
		apparatus bowieTruck = new apparatus(839, APPARATUS_TYPE.TK);
		// Laurel Firehouse Apparatus (Station 849)
		apparatus laurelEngine = new apparatus(849, APPARATUS_TYPE.E);
		apparatus laurelRescueSquad = new apparatus(849, APPARATUS_TYPE.RS);
		// Bladensburg Firehouse Apparatus (Station 809)
		apparatus bladensburgEngine = new apparatus(809, APPARATUS_TYPE.E);
		apparatus bladensburgTruck = new apparatus(809, APPARATUS_TYPE.TK);
		// Riverdale Firehouse Apparatus (Station 807)
		apparatus riverdaleEngine = new apparatus(807, APPARATUS_TYPE.E);
		apparatus riverdaleTruck = new apparatus(807, APPARATUS_TYPE.TK);
		// Berwyn Heights Firehouse Apparatus (Station 814)
		apparatus berwynHeightsTruck = new apparatus(814, APPARATUS_TYPE.TK);
		apparatus berwynHeightsSquad = new apparatus(814, APPARATUS_TYPE.RS);
		// Lanham Firehouse Apparatus (Station 848)
		apparatus lanhamEngine = new apparatus(848, APPARATUS_TYPE.E);
		// Kentland Firehouse Apparatus (Station 833)
		apparatus kentlandEngine = new apparatus(833, APPARATUS_TYPE.E);
		apparatus kentlandTruck = new apparatus(833, APPARATUS_TYPE.TK);
		apparatus kentlandRescueEngine = new apparatus(833, APPARATUS_TYPE.RE);
		
		// Oxon Hill Firehouse Apparatus (Station 842)
		apparatus oxonHillEngine = new apparatus(842, APPARATUS_TYPE.E);
		apparatus oxonHillTruck = new apparatus(842, APPARATUS_TYPE.TK);
		// Suitland Firehouse Apparatus (Station 829)
		apparatus suitlandEngine = new apparatus(829, APPARATUS_TYPE.E);
		apparatus suitlandRescueEngine = new apparatus(829, APPARATUS_TYPE.RE);
		// Upper Marlboro Firehouse Apparatus (Station 820)
		apparatus upperMarlboroEngine = new apparatus(820, APPARATUS_TYPE.E);
		apparatus upperMarlboroSquad = new apparatus(820,APPARATUS_TYPE.RS);
		// Accokeek Firehouse Apparatus (Station 824)
		apparatus accokeekEngine = new apparatus(824, APPARATUS_TYPE.E);
		// Clinton Firehouse Apparatus (Station 825)
		apparatus clintonEngine = new apparatus(825, APPARATUS_TYPE.E);
		// Landover Firehouse Apparatus (Station 846)
		apparatus landoverEngine = new apparatus(846, APPARATUS_TYPE.E);
		apparatus landoverRescueSquad = new apparatus(846, APPARATUS_TYPE.RS);
		//Langley Park
		apparatus langleyparkEngine = new apparatus(834, APPARATUS_TYPE.E);
		apparatus langleyparkTruck = new apparatus(834, APPARATUS_TYPE.TK);
		//Landover Hills
		apparatus landoverhillsEngine = new apparatus(830,APPARATUS_TYPE.E);

		
		
		// Hyattsville Firehouse (Station 801)
		hyattsville.addApp(hyattsvilleEngine);
		hyattsville.addApp(hyattsvilleTruck);
		hyattsville.addApp(hyattsvilleSquad);

		// College Park Firehouse (Station 812)
		collegePark.addApp(collegeParkEngine);
		collegePark.addApp(collegeParkTruck);

		// Greenbelt Firehouse (Station 835)
		greenbelt.addApp(greenbeltEngine);

		// Bowie Firehouse (Station 839)
		bowie.addApp(bowieEngine);
		bowie.addApp(bowieTruck);

		// Laurel Firehouse (Station 849)
		laurel.addApp(laurelEngine);
		laurel.addApp(laurelRescueSquad);

		// Bladensburg Firehouse (Station 809)
		bladensburg.addApp(bladensburgEngine);
		bladensburg.addApp(bladensburgTruck);

		// Riverdale Firehouse (Station 807)
		riverdale.addApp(riverdaleEngine);
		riverdale.addApp(riverdaleTruck);

		// Berwyn Heights Firehouse (Station 814)
		berwynHeights.addApp(berwynHeightsTruck);
		berwynHeights.addApp(berwynHeightsSquad);

		// Lanham Firehouse (Station 848)
		lanham.addApp(lanhamEngine);

		// Kentland Firehouse (Station 833)
		kentland.addApp(kentlandEngine);
		kentland.addApp(kentlandTruck);
		kentland.addApp(kentlandRescueEngine);

		

		// Oxon Hill Firehouse (Station 842)
		oxonHill.addApp(oxonHillEngine);
		oxonHill.addApp(oxonHillTruck);

		// Suitland Firehouse (Station 829)
		suitland.addApp(suitlandEngine);
		suitland.addApp(suitlandRescueEngine);

		// Upper Marlboro Firehouse (Station 820)
		upperMarlboro.addApp(upperMarlboroEngine);
		upperMarlboro.addApp(upperMarlboroSquad);

		// Accokeek Firehouse (Station 824)
		accokeek.addApp(accokeekEngine);

		// Clinton Firehouse (Station 825)
		clinton.addApp(clintonEngine);

		// Landover Firehouse (Station 846)
		landover.addApp(landoverEngine);
		landover.addApp(landoverRescueSquad);
		//Langley Park
		langleypk.addApp(langleyparkEngine);
		langleypk.addApp(langleyparkTruck);
		//Landover Hills
		landoverhills.addApp(landoverhillsEngine);
		
		PG.addFh(hyattsville);
        PG.addFh(collegePark);
        PG.addFh(greenbelt);
        PG.addFh(bowie);
        PG.addFh(laurel);
        PG.addFh(bladensburg);
        PG.addFh(berwynHeights);
        PG.addFh(lanham);
        PG.addFh(kentland);
        PG.addFh(oxonHill);
        PG.addFh(suitland);
        PG.addFh(upperMarlboro);
        PG.addFh(accokeek);
        PG.addFh(clinton);
        PG.addFh(landover);
        PG.addFh(langleypk);
        PG.addFh(landoverhills);
                
                
        
        
        
         
        String address = "6515 Belcrest Road, Hyattsville MD";
        StringBuilder notes = new StringBuilder("service call");
		incident oneBox = new incident("serv", address ,PG, notes , "TGA1");
		
		oneBox.printInc();
		
		
		
		

	}

}

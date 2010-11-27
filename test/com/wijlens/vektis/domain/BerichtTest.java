package com.wijlens.vektis.domain;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.wijlens.vektis.Utils;

public class BerichtTest {

	@Test
	public void kinderen(){
		Bericht bericht = new Bericht(Utils.getFile("MZ301.asc"));
        Assert.assertEquals(4, bericht.kinderen().size());
        
        bericht.parse();
	}
	
	
	
	
	@Test
	public void testGetMaxLineSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElement() {
		fail("Not yet implemented");
	}

}

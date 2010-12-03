package com.wijlens.vektis.domain;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.wijlens.vektis.Utils;

public class BerichtTest {

	private Bericht bericht;
	
	@Before
	public void setUp(){
		bericht = new Bericht(Utils.getFile("MZ301.asc"));
	}

	@Test
	public void kinderen(){
		
        Assert.assertEquals(4, bericht.kinderen().size());
        
        bericht.parse();
	}
	
	
	
	
	@Test
	public void testGetMaxLineSize() {
		Assert.assertEquals(27, bericht.getMaxLineSize());
	}

	@Test
	public void testGetElement() {
		fail("Not yet implemented");
	}

}

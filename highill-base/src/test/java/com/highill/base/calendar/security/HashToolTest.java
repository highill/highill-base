package com.highill.base.calendar.security;

import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.highill.base.security.HashTool;


@RunWith(BlockJUnit4ClassRunner.class)
public class HashToolTest {
	
	@Test
	public void md5() {
		Map<String, String> md5Map = new LinkedHashMap<String, String>();
		md5Map.put("abc", "900150983cd24fb0d6963f7d28e17f72");
		md5Map.put("acbd1234", "93c6691c8104bb1bc2f90d940a39cc90");
		md5Map.put("汉字", "8a97ee1fcddc24870fb66b4b58c41214");
		md5Map.put("汉字abcd", "cab2ed93fe04c5c43793917042460203");
		
		for(String param : md5Map.keySet()) {
			String md5 = HashTool.md5(param);
			System.out.println("-----md5 test   " + param + "  --> " + md5);
			TestCase.assertEquals(md5Map.get(param), md5);
		}
		System.out.println("\n\n\n");
	}
	
	@Test
	public void sha256() {
		Map<String, String> sha256Map = new LinkedHashMap<String, String>();
		sha256Map.put("abc", "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad");
		sha256Map.put("abcd1234", "e9cee71ab932fde863338d08be4de9dfe39ea049bdafb342ce659ec5450b69ae");
		sha256Map.put("汉字", "00e5d5601ce310d84ec2875e28c826f7f4c0a473be7fd53cf50e47f1542db4ea");
		sha256Map.put("汉字abcd", "3544e46111718e766955f40627763a2d2f0feca3fcf1edb022ce6ed98a0b569c");
		
		for(String param : sha256Map.keySet()) {
			String sha256 = HashTool.sha256(param);
			System.out.println("-----sha256 test   " + param + "  --> " + sha256);
			TestCase.assertEquals(sha256Map.get(param), sha256);
		}
		System.out.println("\n\n\n");
	}
	
	@Test
	public void sha512() {
		Map<String, String> sha512Map = new LinkedHashMap<String, String>();
		sha512Map.put("abc", "ddaf35a193617abacc417349ae20413112e6fa4e89a97ea20a9eeee64b55d39a2192992a274fc1a836ba3c23a3feebbd454d4423643ce80e2a9ac94fa54ca49f");
		sha512Map.put("abcd1234", "925f43c3cfb956bbe3c6aa8023ba7ad5cfa21d104186fffc69e768e55940d9653b1cd36fba614fba2e1844f4436da20f83750c6ec1db356da154691bdd71a9b1");
		sha512Map.put("汉字", "4613be09d9824ed5b60b6d6b58ed04863f34f8b3f164af64924e282f550e71db02bfb5d8b4079fb47a81a07885d0c720ef69b0cf4a3446d4c4d2b24ed162c344");
		sha512Map.put("汉字abcd", "869b4a2383c493de601efa22a637d066fe4c9d4aff338b13d880e17bc88c215e00c3d958d82656bc1dcf9ff432751cc8b82e3fb7b554aa15268ecca17ae516b9");
		
		for(String param : sha512Map.keySet()) {
			String sha512 = HashTool.sha512(param);
			System.out.println("-----sha512 test    " + param + "  -->  " + sha512);
		}
		System.out.println("\n\n\n");
	}
	
	
	

}

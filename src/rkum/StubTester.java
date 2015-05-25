package rkum;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;



public class StubTester {

MapDriver<Object, Text, Text, LongWritable>	mapDriver;
ReduceDriver<Text, LongWritable, Text, LongWritable> reduceDriver;
MapReduceDriver<Object, Text, Text, LongWritable, Text, LongWritable> mapReduceDriver;
List<Pair<Text, LongWritable>> output;


@Before	
	public void Setup()
		{
			StubMapper1 mapper = new StubMapper1();
			mapDriver = new MapDriver<Object, Text, Text, LongWritable>();
			mapDriver.setMapper(mapper);
			/*
			StubReducer3 reducer = new StubReducer3();
			reduceDriver = new ReduceDriver<Text, LongWritable, Text, LongWritable>();
			reduceDriver.setReducer(reducer);
			
			mapReduceDriver = new MapReduceDriver<Object, Text, Text, LongWritable, Text, LongWritable>();
			mapReduceDriver.setMapper(mapper);
			mapReduceDriver.setReducer(reducer);*/
			
		}

	@Test
 	public void testMapper() throws IOException
		{
			System.out.println("Mapper test started");
 			mapDriver.withInput(new Pair<Object, Text> ("1", new Text("A	[5, B, C]")));
 			//mapDriver.withInput(new Pair<Object, Text> ("2", new Text("B	[1, C]")));
 			//mapDriver.withInput(new Pair<Object, Text> ("3", new Text("C	[11, F]")));
 			//mapDriver.withInput(new Pair<Object, Text> ("4", new Text("D	[12]")));
 			//mapDriver.withInput(new Pair<Object, Text> ("5", new Text("E	[0]")));
 			//mapDriver.withInput(new Pair<Object, Text> ("6", new Text("C 11")));
 			//mapDriver.withInput(new Pair<Object, Text> ("1", new Text("C F")));
 			//mapDriver.withInput(new Pair<Object, Text> ("1", new Text("D 12")));
 			//mapDriver.withInput(new Pair<Object, Text> ("1", new Text("E 0")));
 						
			output = mapDriver.run();
			
			for (Pair<Text, LongWritable> p : output) 
				{
					System.out.println("Mapper Output :   " + p.getFirst() + "->" + p.getSecond());
				}
			System.out.println("Mapper test ended");
		}

/*
//	@Test
 	public void testReducer() throws IOException

 	{
 		System.out.println("Reducer testing started");

 			/*List<LongWritable>	values = new ArrayList<LongWritable>();
 		    values.add(new LongWritable(1));
 		    values.add(new LongWritable(1));
 		    values.add(new LongWritable(1));
 		   	values.add(new LongWritable(9));
 		  	values.add(new LongWritable(9));
	 		values.add(new LongWritable(9));
	 		values.add(new LongWritable(1));
	 		values.add(new LongWritable(1));
	 		values.add(new LongWritable(1));*/
/*
	 		
 		//reduceDriver.withInput(new Pair<Object, Text> ("1", new Text("A 5, C")));
		//reduceDriver.withInput(new Pair<Object, Text> ("2", new Text("B 1, C")));
		//reduceDriver.withInput(new Pair<Object, Text> ("3", new Text("C 11, F")));
		//reduceDriver.withInput(new Pair<Object, Text> ("4", new Text("D 3, A")));
		//reduceDriver.withInput(new Pair<Object, Text> ("5", new Text("B 1")));
		//reduceDriver.withInput(new Pair<Object, Text> ("6", new Text("C 11")));
 		
	 	//reduceDriver.withInput(new Text("the"), values);

 		    List<Pair<Text, LongWritable>> output1 = reduceDriver.run();
 		  
 		 for (Pair<Text, LongWritable> p : output1) 
			{
				System.out.println("Reducer Output :   " + p.getFirst() + "->" + p.getSecond());
			}
 		System.out.println("Reducer test ended");
 	}
*/
 	
  /*@Test
 	public void testmapReducer() throws IOException
		{
 		System.out.println("MapReducer test started");
 			mapReduceDriver.withInput(new Pair<Object, Text> ("1", new Text("A C")));
 			mapReduceDriver.withInput(new Pair<Object, Text> ("2", new Text("B C")));
 			mapReduceDriver.withInput(new Pair<Object, Text> ("3", new Text("C F")));
 			mapReduceDriver.withInput(new Pair<Object, Text> ("4", new Text("A 5")));
 			mapReduceDriver.withInput(new Pair<Object, Text> ("5", new Text("B 1")));
 			mapReduceDriver.withInput(new Pair<Object, Text> ("5", new Text("C 11")));
 			//mapReduceDriver.withInput(new Pair<Object, Text> ("6", new Text("User6 AGCT")));
		
			List<Pair<Text, LongWritable>> output = mapReduceDriver.run();
			
	//		assertEquals(11, output.size());
			
			for (Pair<Text, LongWritable> p : output) 
				{
					System.out.println(p.getFirst() + "->" + p.getSecond());
				}
		System.out.println("MapReducer test Ended");
		}*/
}
package juc.test.com.jmh.test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
//
//@OutputTimeUnit(TimeUnit.MICROSECONDS) // 测试方法平均执行时间
//@BenchmarkMode(Mode.AverageTime) // 输出结果的时间粒度为微秒
public class Demo01 {
	

	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	@BenchmarkMode(Mode.SampleTime)
	@Benchmark
	public void runCalendar() {
		Calendar calendar = Calendar.getInstance();
	}
	
//	@Benchmark
//	@Threads(5)
//	public void runJoda() {
//		Date dateTime = new Date();
//	}
//	
//	@Benchmark
//	@Threads(5)
//	public void runSystem() {
//		long result = System.currentTimeMillis();
//	}

	
	public static void main(String[] args) throws RunnerException, IOException {
		Options options = 
				new OptionsBuilder().include(Demo01.class.getName()).forks(1).build();
		new Runner(options).run();
	}

}

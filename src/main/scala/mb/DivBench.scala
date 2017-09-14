package mb

import java.util.concurrent.TimeUnit

import code.Divs
import org.openjdk.jmh.annotations._

//[info] Benchmark                                  Mode  Cnt   Score   Error   Units
//[info] PrivateVsPublicFieldsBenchmark.testField  thrpt   20  73.095 ± 1.404  ops/ms
//[info] PrivateVsPublicFieldsBenchmark.testLocal  thrpt   20  77.611 ± 1.065  ops/ms


@State(Scope.Thread)
class ThreadStateDivs {
  val divs = new Divs()
}

@Warmup(iterations = 20)
@Measurement(iterations = 20)
@Fork(1)
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class DivBench {

  @Benchmark
  def testByConstFromObj(state: ThreadStateDivs):Int = state.divs.byConstFromObj(1000)

  @Benchmark
  def testByLocalConst(state: ThreadStateDivs):Int = state.divs.byConstLocal(1000)

  @Benchmark
  def testByShift(state: ThreadStateDivs):Int = state.divs.byShift(1000)

}

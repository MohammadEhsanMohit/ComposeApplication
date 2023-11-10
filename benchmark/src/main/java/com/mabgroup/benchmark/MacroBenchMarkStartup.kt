package com.mabgroup.benchmark

import androidx.benchmark.macro.BaselineProfileMode
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColdStartupBenchmark : AbstractStartupBenchmark(StartupMode.COLD)

@RunWith(AndroidJUnit4::class)
class WarmStartupBenchmark : AbstractStartupBenchmark(StartupMode.WARM)

class HotStartupBenchmark : AbstractStartupBenchmark(StartupMode.HOT)

abstract class AbstractStartupBenchmark(private val startupMode: StartupMode) {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startupNoCompilation() = startup(CompilationMode.None())

    @Test
    fun startupPartialCompilation() = startup(
        CompilationMode.Partial(
            baselineProfileMode = BaselineProfileMode.Disable,
            warmupIterations = 3
        )
    )

    @Test
    fun startupPartialWithBaselineProfiles() =
        startup(CompilationMode.Partial(baselineProfileMode = BaselineProfileMode.Require))

    @Test
    fun startupFullCompilation() = startup(CompilationMode.Full())

    private fun startup(compilationMode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = TARGET_PACKAGE,
        metrics = listOf(StartupTimingMetric()),
        compilationMode = compilationMode,
        iterations = DEFAULT_ITERATIONS,
        startupMode = startupMode,
        setupBlock = {
            pressHome()
        }
    ) {
        startActivityAndWait()
    }
}
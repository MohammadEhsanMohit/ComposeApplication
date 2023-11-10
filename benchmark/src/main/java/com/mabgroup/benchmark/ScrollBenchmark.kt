package com.mabgroup.benchmark

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.ExperimentalMetricApi
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.TraceSectionMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalMetricApi::class)
class ScrollBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    @SdkSuppress(minSdkVersion = 24)
    fun noCompilation() = scroll(CompilationMode.None())

    @Test
    fun defaultCompilation() = scroll(CompilationMode.DEFAULT)

    @Test
    fun full() = scroll(CompilationMode.Full())

    private fun scroll(compilationMode: CompilationMode) {
        var firstStart = true
        benchmarkRule.measureRepeated(
            packageName = TARGET_PACKAGE,
            metrics = listOf(
                TraceSectionMetric("ClickTrace"),
                StartupTimingMetric(),
                FrameTimingMetric()
            ),
            compilationMode = compilationMode,
            startupMode = null,
            iterations = DEFAULT_ITERATIONS,
            setupBlock = {
                startActivityAndWait()
                if(firstStart) {
                    val logo = device.findObject(By.res("splash:logo"))
                    logo.click()
                    firstStart = false
                }
            }
        ) {
            //device.wait(Until.hasObject(By.res("splash:logo")),10000)

            device.wait(Until.hasObject(By.res("bottom:Bar")), 10000)
            val navBottom = device.findObject(
                By.res("bottom:Bar")
            )
            if(navBottom == null) {
                TestCase.fail("Bottom nav not found!")
            }
            val listBottomChild = navBottom.children
            if(listBottomChild == null) {
                TestCase.fail("BottomBar Has No Child")
            }
            listBottomChild[2].click()

            device.wait(Until.hasObject(By.scrollable(true)), 5_000)

            val scrollableObject = device.findObject(By.scrollable(true))
            if(scrollableObject == null) {
                TestCase.fail("No scrollable view found in hierarchy")
            }
            scrollableObject.setGestureMargin(device.displayWidth / 20)
            scrollableObject?.apply {
                repeat(2) {
                    fling(Direction.DOWN)
                }
                repeat(2) {
                    fling(Direction.UP)
                }
            }
        }
    }
}
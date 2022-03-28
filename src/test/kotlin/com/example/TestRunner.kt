package com.example

import org.junit.platform.engine.discovery.DiscoverySelectors.selectDirectory
import org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.launcher.core.LauncherFactory
import org.junit.platform.launcher.listeners.SummaryGeneratingListener
import java.io.PrintWriter
import kotlin.system.exitProcess

fun main() {
    runTests()
}

private fun runTests() {
    val listener = SummaryGeneratingListener()

    val request = LauncherDiscoveryRequestBuilder.request()
        .selectors(selectDirectory("src/test"))
        .selectors(selectPackage("com.example"))
        .build()

    val launcher = LauncherFactory.create()
    launcher.registerTestExecutionListeners(listener)
    launcher.execute(request)

    val out = PrintWriter(System.out)
    listener.summary.printFailuresTo(out)
    listener.summary.printTo(out)

    if (listener.summary.testsFailedCount > 0) {
        exitProcess(1)
    } else {
        exitProcess(0)
    }
}

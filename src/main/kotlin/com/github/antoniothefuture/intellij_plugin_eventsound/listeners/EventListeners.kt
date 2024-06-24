package com.github.antoniothefuture.intellij_plugin_eventsound.listeners

import com.github.antoniothefuture.intellij_plugin_eventsound.services.MyAppServiceImpl
import com.intellij.codeInspection.ex.InspectListener
import com.intellij.codeInspection.ex.InspectionToolWrapper
import com.intellij.execution.ExecutionListener
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.testframework.sm.runner.SMTRunnerEventsListener
import com.intellij.execution.testframework.sm.runner.SMTestProxy
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vcs.BranchChangeListener
import com.intellij.psi.PsiFile
import com.intellij.remoteServer.runtime.ConnectionStatus
import com.intellij.remoteServer.runtime.ServerConnection
import com.intellij.remoteServer.runtime.ServerConnectionListener
import com.intellij.task.ProjectTaskContext
import com.intellij.task.ProjectTaskListener
import com.intellij.task.ProjectTaskManager


internal class ESInspectListener: InspectListener {
    override fun inspectionFinished(
        duration: Long,
        threadId: Long,
        problemsCount: Int,
        tool: InspectionToolWrapper<*, *>?,
        kind: InspectListener.InspectionKind?,
        file: PsiFile?,
        project: Project?
    ) {
        super.inspectionFinished(duration, threadId, problemsCount, tool, kind, file, project)
        service<MyAppServiceImpl>().eventTriggered("Inspect:inspectionFinished")
    }

    override fun fileAnalyzed(file: PsiFile?, project: Project?) {
        super.fileAnalyzed(file, project)
        service<MyAppServiceImpl>().eventTriggered("Inspect:fileAnalyzed")
    }

}

internal class ESExecutionListener: ExecutionListener {
    override fun processStartScheduled(executorId: String, env: ExecutionEnvironment) {
        super.processStartScheduled(executorId, env)
        service<MyAppServiceImpl>().eventTriggered("Execution:processStartScheduled")
    }

    override fun processStarting(executorId: String, env: ExecutionEnvironment, handler: ProcessHandler) {
        super.processStarting(executorId, env, handler)
        service<MyAppServiceImpl>().eventTriggered("Execution:processStarting")
    }

    override fun processNotStarted(executorId: String, env: ExecutionEnvironment, cause: Throwable?) {
        super.processNotStarted(executorId, env, cause)
        service<MyAppServiceImpl>().eventTriggered("Execution:processNotStarted")
    }

    override fun processStarted(executorId: String, env: ExecutionEnvironment, handler: ProcessHandler) {
        super.processStarted(executorId, env, handler)
        service<MyAppServiceImpl>().eventTriggered("Execution:processStarted")
    }

    override fun processTerminating(executorId: String, env: ExecutionEnvironment, handler: ProcessHandler) {
        super.processTerminating(executorId, env, handler)
        service<MyAppServiceImpl>().eventTriggered("Execution:processTerminating")
    }

    override fun processTerminated(
        executorId: String,
        env: ExecutionEnvironment,
        handler: ProcessHandler,
        exitCode: Int
    ) {
        super.processTerminated(executorId, env, handler, exitCode)
        service<MyAppServiceImpl>().eventTriggered("Execution:processTerminated")
    }

}

internal class ESSMTRunnerEventsListener: SMTRunnerEventsListener {
    override fun onTestingStarted(testsRoot: SMTestProxy.SMRootTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestingStarted")
    }

    override fun onTestingFinished(testsRoot: SMTestProxy.SMRootTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestingFinished")
    }

    override fun onTestsCountInSuite(count: Int) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestsCountInSuite")
    }

    override fun onTestStarted(test: SMTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestStarted")
    }

    override fun onTestFinished(test: SMTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestFinished")
    }

    override fun onTestFailed(test: SMTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestFailed")
    }

    override fun onTestIgnored(test: SMTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestIgnored")
    }

    override fun onSuiteFinished(suite: SMTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onTestIgnored")
    }

    override fun onSuiteStarted(suite: SMTestProxy) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onSuiteStarted")
    }

    override fun onCustomProgressTestsCategory(categoryName: String?, testCount: Int) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onCustomProgressTestsCategory")
    }

    override fun onCustomProgressTestStarted() {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onCustomProgressTestStarted")
    }

    override fun onCustomProgressTestFailed() {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onCustomProgressTestFailed")
    }

    override fun onCustomProgressTestFinished() {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onCustomProgressTestFinished")
    }

    override fun onSuiteTreeNodeAdded(testProxy: SMTestProxy?) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onSuiteTreeNodeAdded")
    }

    override fun onSuiteTreeStarted(suite: SMTestProxy?) {
        service<MyAppServiceImpl>().eventTriggered("SMTRunnerEvents:onSuiteTreeStarted")
    }

}

internal class ESBranchChangeListener: BranchChangeListener {
    override fun branchWillChange(branchName: String) {
        service<MyAppServiceImpl>().eventTriggered("Branch:branchWillChange")
    }

    override fun branchHasChanged(branchName: String) {
        service<MyAppServiceImpl>().eventTriggered("Branch:branchHasChanged")
    }

}

internal class ESServerConnectionListener: ServerConnectionListener {
    override fun onConnectionCreated(connection: ServerConnection<*>) {
        service<MyAppServiceImpl>().eventTriggered("ServerConnection:onConnectionCreated")
    }

    override fun onConnectionStatusChanged(connection: ServerConnection<*>) {
        if (connection.status === ConnectionStatus.CONNECTING) {
            service<MyAppServiceImpl>().eventTriggered("ServerConnection:onConnectionStatusChanged#Connecting")
        }
        if (connection.status === ConnectionStatus.CONNECTED) {
            service<MyAppServiceImpl>().eventTriggered("ServerConnection:onConnectionStatusChanged#Connected")
        }
        if (connection.status === ConnectionStatus.DISCONNECTED) {
            service<MyAppServiceImpl>().eventTriggered("ServerConnection:onConnectionStatusChanged#Disconnected")
        }
    }

    override fun onDeploymentsChanged(connection: ServerConnection<*>) {
        service<MyAppServiceImpl>().eventTriggered("ServerConnection:onDeploymentsChanged")
    }

}


internal class ESProjectTaskListener: ProjectTaskListener {
    override fun started(context: ProjectTaskContext) {
        super.started(context)
        service<MyAppServiceImpl>().eventTriggered("ProjectTask:started")
    }

    override fun finished(result: ProjectTaskManager.Result) {
        super.finished(result)
        if (result.hasErrors()) {
            service<MyAppServiceImpl>().eventTriggered("ProjectTask:finished#Success")
        } else {
            service<MyAppServiceImpl>().eventTriggered("ProjectTask:finished#Error")
        }
    }
}



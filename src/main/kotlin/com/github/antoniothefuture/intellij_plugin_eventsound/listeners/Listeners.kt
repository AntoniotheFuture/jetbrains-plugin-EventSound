package com.github.antoniothefuture.intellij_plugin_eventsound.listeners

import com.intellij.analysis.problemsView.Problem
import com.intellij.analysis.problemsView.ProblemsListener
import com.intellij.application.options.editor.EditorOptionsListener
import com.intellij.codeInsight.actions.ReaderModeListener
import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.settings.CodeVisionSettings.CodeVisionSettingsListener
import com.intellij.codeInsight.completion.CompletionContributorListener
import com.intellij.codeInsight.completion.CompletionInitializationContextImpl
import com.intellij.codeInsight.completion.CompletionPhaseListener
import com.intellij.codeInsight.completion.CompletionProgressIndicator
import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer.DaemonListener
import com.intellij.codeInsight.daemon.impl.analysis.FileHighlightingSetting
// Incompatible version
// import com.intellij.codeInsight.daemon.impl.EditorTracker.EditorTrackerListener
import com.intellij.codeInsight.daemon.impl.analysis.FileHighlightingSettingListener
import com.intellij.codeInsight.documentation.render.DocRenderItem
import com.intellij.codeInsight.documentation.render.DocRenderItemManagerImpl.Listener
import com.intellij.codeInsight.hint.EditorHintListener
import com.intellij.codeInsight.hint.ExternalParameterInfoChangesProvider
import com.intellij.codeInsight.hints.InlayHintsSettings.SettingsListener
import com.intellij.codeInsight.lookup.Lookup
// Incompatible version
// import com.intellij.codeInsight.inline.completion.InlineCompletionInstallListener
import com.intellij.codeInsight.lookup.LookupManagerListener
import com.intellij.codeInsight.template.TemplateManagerListener
import com.intellij.codeInsight.template.impl.TemplateState
import com.intellij.codeInspection.InspectionProfile
import com.intellij.codeInspection.ex.InspectListener
import com.intellij.codeInspection.ex.InspectionToolWrapper
import com.intellij.configurationStore.BatchUpdateListener
import com.intellij.diagnostic.IdePerformanceListener
import com.intellij.diagnostic.RunnablesListener
import com.intellij.diagnostic.ThreadDump
import com.intellij.dvcs.branch.DvcsBranchManager.DvcsBranchManagerListener
import com.intellij.dvcs.branch.GroupingKey
import com.intellij.dvcs.repo.VcsRepositoryMappingListener
import com.intellij.execution.*
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.dashboard.RunDashboardListener
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.mediator.daemon.QuotaOptions
// Incompatible version
// import com.intellij.execution.multilaunch.execution.messaging.ExecutionNotifier
import com.intellij.execution.process.elevation.settings.ElevationSettings.Listener as ElevationSettingsListener
import com.intellij.execution.runToolbar.data.RWSlotsConfigurationListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.services.ServiceEventListener
import com.intellij.execution.testframework.sm.runner.SMTRunnerEventsListener
import com.intellij.execution.testframework.sm.runner.SMTestProxy
import com.intellij.execution.ui.RunContentDescriptor
import com.intellij.execution.ui.RunContentWithExecutorListener
import com.intellij.facet.Facet
// Incompatible version
// import com.intellij.execution.ui.RunToolbarPopup.Listener as RunToolbarPopupListener
import com.intellij.facet.FacetManagerListener
import com.intellij.featureStatistics.FeatureDescriptor
// Incompatible version
// import com.intellij.featureStatistics.FeatureStatisticsUpdateListener
import com.intellij.featureStatistics.FeaturesRegistryListener
import com.intellij.find.FindModelListener
import com.intellij.ide.AppLifecycleListener
import com.intellij.ide.FrameStateListener
import com.intellij.ide.PowerSaveMode.Listener as PowerSaveModeListener
import com.intellij.ide.RecentProjectsManager.RecentProjectsChange
import com.intellij.ide.SaveAndSyncHandler
import com.intellij.ide.SaveAndSyncHandlerListener
// Incompatible version
// import com.intellij.ide.actions.searcheverywhere.SEHeaderActionListener
import com.intellij.ide.actions.searcheverywhere.SETabSwitcherListener
import com.intellij.ide.actions.searcheverywhere.SearchEverywhereContributor
import com.intellij.ide.actions.searcheverywhere.SearchEverywhereFoundElementInfo
import com.intellij.ide.actions.searcheverywhere.SearchListener
import com.intellij.ide.bookmark.Bookmark
import com.intellij.ide.bookmark.BookmarkGroup
import com.intellij.ide.bookmark.BookmarksListener
import com.intellij.ide.bookmarks.BookmarksListener as bookmarksBookmarksListener
import com.intellij.ide.file.BatchFileChangeListener
import com.intellij.ide.gdpr.DataSharingSettingsChangeListener
// Incompatible version
// import com.intellij.ide.impl.TrustedProjects.TrustStateListener
import com.intellij.ide.lightEdit.LightEditServiceListener
// Incompatible version
// import com.intellij.ide.navigationToolbar.experimental.NewToolbarRootPaneExtension.ExperimentalToolbarStateListener
import com.intellij.ide.plugins.DynamicPluginListener
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.auth.PluginRepositoryAuthListener
import com.intellij.ide.projectView.impl.AbstractProjectViewPane
// Incompatible version
// import com.intellij.ide.projectView.ProjectViewSelectionTopic.ProjectViewSelectionListener
import com.intellij.ide.projectView.impl.ProjectViewListener
import com.intellij.ide.trustedProjects.TrustedProjectsListener
import com.intellij.ide.trustedProjects.TrustedProjectsLocator
import com.intellij.ide.ui.*
import com.intellij.ide.ui.customization.CustomActionsListener
import com.intellij.ide.ui.search.ComponentHighlightingListener
import com.intellij.ide.util.FileStructurePopupListener
// Incompatible version
// import com.intellij.ide.util.scopeChooser.ScopeEditorPanel.SettingsChangedListener
import com.intellij.internal.statistic.eventLog.EventLogConfigOptionsListener
import com.intellij.javaee.ExternalResourceListener
import com.intellij.lang.annotation.AnnotationSession
// Incompatible version
// import com.intellij.lang.documentation.ide.impl.DocumentationPopupListener
import com.intellij.notification.ActionCenter.EventListener
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.actionSystem.ex.AnActionListener
import com.intellij.openapi.actionSystem.ex.QuickList
import com.intellij.openapi.actionSystem.impl.segmentedActionBar.ToolbarActionsUpdatedListener
import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.command.CommandEvent
import com.intellij.openapi.command.CommandListener
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.actionSystem.LatencyListener
import com.intellij.openapi.editor.colors.EditorColorsListener
import com.intellij.openapi.editor.colors.EditorColorsScheme
import com.intellij.openapi.editor.colors.impl.EditorColorsManagerListener
import com.intellij.openapi.editor.ex.DocumentBulkUpdateListener
import com.intellij.openapi.externalSystem.autoimport.ExternalSystemProjectNotificationAware.Listener as ExternalSystemProjectNotificationAwareListener
import com.intellij.openapi.externalSystem.service.project.manage.ProjectDataImportListener
import com.intellij.openapi.fileEditor.*
import com.intellij.openapi.fileEditor.FileEditorManagerListener.Before
import com.intellij.openapi.fileEditor.ex.FileEditorWithProvider
import com.intellij.openapi.fileEditor.impl.IdeDocumentHistoryImpl
import com.intellij.openapi.fileEditor.impl.IdeDocumentHistoryImpl.RecentPlacesListener
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.FileTypeEvent
import com.intellij.openapi.fileTypes.FileTypeListener
import com.intellij.openapi.keymap.Keymap
import com.intellij.openapi.keymap.KeymapManagerListener
import com.intellij.openapi.keymap.impl.ui.KeymapListener
import com.intellij.openapi.module.Module
import com.intellij.openapi.options.Configurable
// Incompatible version
// import com.intellij.openapi.options.advanced.AdvancedSettings.AdvancedSettingsChangeListener
import com.intellij.openapi.options.newEditor.ExternalUpdateRequest
import com.intellij.openapi.progress.ProgressIndicator
// Incompatible version
// import com.intellij.openapi.options.newEditor.SettingsDialogListener
import com.intellij.openapi.progress.ProgressManagerListener
import com.intellij.openapi.progress.Task
import com.intellij.openapi.progress.TaskInfo
import com.intellij.openapi.progress.impl.ProgressSuspender
import com.intellij.openapi.progress.impl.ProgressSuspender.SuspenderListener
import com.intellij.openapi.progress.util.ProgressWindow
import com.intellij.openapi.project.*
import com.intellij.openapi.progress.util.ProgressWindow.Listener as ProgressWindowListener
import com.intellij.openapi.project.DumbService.DumbModeListener
// Incompatible version
// import com.intellij.openapi.project.ProjectNameListener
import com.intellij.openapi.project.impl.ProjectLifecycleListener
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.ProjectJdkTable.Listener as ProjectJdkTableListener
import com.intellij.openapi.roots.AdditionalLibraryRootsListener
import com.intellij.openapi.roots.ModuleRootEvent
import com.intellij.openapi.roots.ModuleRootListener
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.registry.RegistryValue
// Incompatible version
// import com.intellij.openapi.ui.popup.BalloonListener
import com.intellij.openapi.util.registry.RegistryValueListener
import com.intellij.openapi.vcs.*
import com.intellij.openapi.vcs.changes.*
import com.intellij.openapi.vcs.changes.ChangesViewModifier.ChangesViewModifierListener
import com.intellij.openapi.vcs.changes.ChangesViewWorkflowManager.ChangesViewWorkflowListener
// Incompatible version
// import com.intellij.openapi.vcs.changes.VcsEditorTabFilesManager.VcsEditorTabFilesListener
import com.intellij.openapi.vcs.changes.VcsFreezingProcess.Listener as VcsFreezingProcessListener
import com.intellij.openapi.vcs.changes.VcsManagedFilesHolder.VcsManagedFilesHolderListener
import com.intellij.openapi.vcs.changes.committed.CommittedChangesListener
import com.intellij.openapi.vcs.changes.committed.CommittedChangesTreeBrowser.CommittedChangesReloadListener
import com.intellij.openapi.vcs.changes.committed.VcsConfigurationChangeListener.DetailedNotification
import com.intellij.openapi.vcs.changes.committed.VcsConfigurationChangeListener.Notification
import com.intellij.openapi.vcs.changes.shelf.ShelveChangesManagerListener
import com.intellij.openapi.vcs.changes.ui.ChangesViewContentManagerListener
import com.intellij.openapi.vcs.ex.VcsActivationListener
import com.intellij.openapi.vcs.impl.LineStatusTrackerSettingListener
import com.intellij.openapi.vcs.impl.VcsBaseContentProviderListener
import com.intellij.openapi.vcs.update.UpdatedFilesListener
import com.intellij.openapi.vcs.versionBrowser.CommittedChangeList
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManagerListener
import com.intellij.openapi.vfs.encoding.EncodingManagerListener
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import com.intellij.openapi.vfs.pointers.VirtualFilePointer
import com.intellij.openapi.vfs.pointers.VirtualFilePointerListener
import com.intellij.openapi.wm.IdeFrame
import com.intellij.openapi.wm.StatusBarInfo
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.openapi.wm.ex.ProgressIndicatorEx
import com.intellij.openapi.wm.ex.ToolWindowManagerListener
import com.intellij.openapi.wm.impl.TitleInfoProvider.TitleInfoProviderListener
import com.intellij.openapi.wm.impl.welcomeScreen.WelcomeBalloonLayoutImpl.BalloonNotificationListener
import com.intellij.openapi.wm.impl.welcomeScreen.WelcomeScreenComponentListener
import com.intellij.openapi.wm.impl.welcomeScreen.cloneableProjects.CloneableProjectsService.CloneProjectListener
import com.intellij.openapi.wm.impl.welcomeScreen.learnIde.coursesInProgress.CourseDeletedListener
import com.intellij.openapi.wm.impl.welcomeScreen.learnIde.coursesInProgress.CourseInfo
import com.intellij.platform.ModuleAttachListener
// Incompatible version
// import com.intellij.platform.externalSystem.testFramework.TestExternalSystemSettingsListener
import com.intellij.problems.ProblemListener
import com.intellij.profile.ProfileChangeAdapter
import com.intellij.psi.PsiDocumentListener
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettingsChangeEvent
import com.intellij.psi.codeStyle.CodeStyleManager.Listener as CodeStyleManagerListener
import com.intellij.psi.codeStyle.CodeStyleSettingsListener
import com.intellij.psi.impl.AnyPsiChangeListener
import com.intellij.psi.impl.PsiDocumentTransactionListener
import com.intellij.psi.search.FileTypeIndex.IndexChangeListener
import com.intellij.refactoring.listeners.RefactoringEventData
import com.intellij.psi.util.PsiModificationTracker.Listener as PsiModificationTrackerListener
import com.intellij.refactoring.listeners.RefactoringEventListener
import com.intellij.remote.RemoteMappingsListener
import com.intellij.remoteServer.configuration.RemoteServer
import com.intellij.remoteServer.configuration.RemoteServerListener
import com.intellij.remoteServer.runtime.ServerConnection
import com.intellij.remoteServer.runtime.ServerConnectionListener
import com.intellij.spellchecker.engine.SpellCheckerEngineListener
import com.intellij.task.ProjectTaskContext
import com.intellij.task.ProjectTaskListener
import com.intellij.task.ProjectTaskManager
import com.intellij.ui.DeferredIcon
import com.intellij.ui.DeferredIconListener
import com.intellij.ui.HintHint
import com.intellij.ui.LightweightHint
import com.intellij.ui.viewModel.extraction.ToolWindowViewModelListener
import com.intellij.util.Function
// Removed
// import com.intellij.util.indexing.UnindexedFilesUpdaterListener
// Incompatible version
// import com.intellij.util.indexing.diagnostic.ProjectIndexingHistory.ProjectIndexingActivityHistoryListener
import com.intellij.vcs.commit.CommitModeManager.CommitModeListener
import com.intellij.vcs.commit.CommitModeManager.SettingsListener as CommitModeManagerSettingsListener
import com.intellij.vcs.commit.message.CommitMessageInspectionProfile.ProfileListener
import com.intellij.vcs.log.impl.VcsLogManager
import com.intellij.vcs.log.impl.VcsProjectLog.ProjectLogListener
import com.intellij.workspaceModel.ide.JpsProjectLoadedListener
import com.intellij.xdebugger.XDebugProcess
import com.intellij.xdebugger.XDebugSession
import com.intellij.xdebugger.XDebuggerManagerListener
import com.intellij.xdebugger.breakpoints.XBreakpoint
import com.intellij.xdebugger.breakpoints.XBreakpointListener
import com.intellij.xdebugger.impl.breakpoints.XDependentBreakpointListener
import com.intellij.xml.breadcrumbs.BreadcrumbsInitListener
import com.intellij.xml.breadcrumbs.BreadcrumbsPanel
import java.awt.AWTEvent
import java.awt.Component
import java.awt.Window
import java.nio.file.Path
import javax.swing.Icon
import javax.swing.JComponent

internal class ESProblemsListener: ProblemsListener {
    override fun problemAppeared(problem: Problem) {
        TODO("Not yet implemented")
    }

    override fun problemDisappeared(problem: Problem) {
        TODO("Not yet implemented")
    }

    override fun problemUpdated(problem: Problem) {
        TODO("Not yet implemented")
    }

}

internal class ESEditorOptionsListener: EditorOptionsListener {
    override fun changesApplied() {
        TODO("Not yet implemented")
    }

}

internal class ESReaderModeListener: ReaderModeListener {
    override fun modeChanged(project: Project) {
        TODO("Not yet implemented")
    }

}

internal class ESCodeVisionSettingsListener: CodeVisionSettingsListener {
    override fun groupPositionChanged(id: String, position: CodeVisionAnchorKind) {
        TODO("Not yet implemented")
    }

}

internal class ESCompletionContributorListener: CompletionContributorListener {
    override fun beforeCompletionContributorThreadStarted(
        indicator: CompletionProgressIndicator,
        initContext: CompletionInitializationContextImpl
    ) {
        TODO("Not yet implemented")
    }

}

internal class ESCompletionPhaseListener: CompletionPhaseListener {
    override fun completionPhaseChanged(isCompletionRunning: Boolean) {
        TODO("Not yet implemented")
    }

}

internal class ESDaemonListener: DaemonListener {
    override fun daemonStarting(fileEditors: MutableCollection<out FileEditor>) {
        super.daemonStarting(fileEditors)
    }

    override fun daemonFinished() {
        super.daemonFinished()
    }

    override fun daemonCancelEventOccurred(reason: String) {
        super.daemonCancelEventOccurred(reason)
    }

    override fun daemonAnnotatorStatisticsGenerated(
        session: AnnotationSession,
        statistics: MutableCollection<out DaemonListener.AnnotatorStatistics>,
        file: PsiFile
    ) {
        super.daemonAnnotatorStatisticsGenerated(session, statistics, file)
    }

}


internal class ESFileHighlightingSettingListener: FileHighlightingSettingListener {
    override fun settingChanged(root: PsiElement, setting: FileHighlightingSetting) {
        TODO("Not yet implemented")
    }

}

internal class ESListener: Listener {
    override fun itemsTextChanged(editor: Editor, items: Collection<DocRenderItem>) {
        TODO("Not yet implemented")
    }

}

internal class ESEditorHintListener: EditorHintListener {
    override fun hintShown(editor: Editor, hint: LightweightHint, flags: Int, hintInfo: HintHint) {
        super.hintShown(editor, hint, flags, hintInfo)
    }

}

internal class ESExternalParameterInfoChangesProvider: ExternalParameterInfoChangesProvider {
    override fun fireChangeAtOffset(editor: Editor?, offset: Int) {
        TODO("Not yet implemented")
    }

}

internal class ESSettingsListener: SettingsListener {
    override fun globalEnabledStatusChanged(newEnabled: Boolean) {
        super.globalEnabledStatusChanged(newEnabled)
    }

    override fun languageStatusChanged() {
        super.languageStatusChanged()
    }

    override fun settingsChanged() {
        super.settingsChanged()
    }

}

internal class ESLookupManagerListener: LookupManagerListener {
    override fun activeLookupChanged(oldLookup: Lookup?, newLookup: Lookup?) {
        TODO("Not yet implemented")
    }

}

internal class ESTemplateManagerListener: TemplateManagerListener {
    override fun templateStarted(state: TemplateState) {
        TODO("Not yet implemented")
    }

}

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
    }

    override fun fileAnalyzed(file: PsiFile?, project: Project?) {
        super.fileAnalyzed(file, project)
    }

}

internal class ESBatchUpdateListener: BatchUpdateListener {
    override fun onBatchUpdateStarted() {
        super.onBatchUpdateStarted()
    }

    override fun onBatchUpdateFinished() {
        super.onBatchUpdateFinished()
    }

}

internal class ESIdePerformanceListener: IdePerformanceListener {
    override fun dumpedThreads(toFile: Path, dump: ThreadDump) {
        super.dumpedThreads(toFile, dump)
    }

    override fun uiFreezeFinished(durationMs: Long, reportDir: Path?) {
        super.uiFreezeFinished(durationMs, reportDir)
    }

    override fun uiFreezeStarted(reportDir: Path) {
        super.uiFreezeStarted(reportDir)
    }

}

internal class ESRunnablesListener: RunnablesListener {
    override fun eventsProcessed(
        eventClass: Class<out AWTEvent>,
        descriptions: MutableCollection<RunnablesListener.InvocationDescription>
    ) {
        super.eventsProcessed(eventClass, descriptions)
    }

    override fun runnablesProcessed(
        invocations: MutableCollection<RunnablesListener.InvocationDescription>,
        infos: MutableCollection<RunnablesListener.InvocationsInfo>,
        wrappers: MutableCollection<RunnablesListener.WrapperDescription>
    ) {
        super.runnablesProcessed(invocations, infos, wrappers)
    }
}

internal class ESDvcsBranchManagerListener: DvcsBranchManagerListener {
    override fun branchFavoriteSettingsChanged() {
        super.branchFavoriteSettingsChanged()
    }

    override fun branchGroupingSettingsChanged(key: GroupingKey, state: Boolean) {
        super.branchGroupingSettingsChanged(key, state)
    }

}

internal class ESVcsRepositoryMappingListener: VcsRepositoryMappingListener {
    override fun mappingChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESExecutionListener: ExecutionListener {
    override fun processStartScheduled(executorId: String, env: ExecutionEnvironment) {
        super.processStartScheduled(executorId, env)
    }

    override fun processStarting(executorId: String, env: ExecutionEnvironment, handler: ProcessHandler) {
        super.processStarting(executorId, env, handler)
    }

    override fun processNotStarted(executorId: String, env: ExecutionEnvironment, cause: Throwable?) {
        super.processNotStarted(executorId, env, cause)
    }

    override fun processStarted(executorId: String, env: ExecutionEnvironment, handler: ProcessHandler) {
        super.processStarted(executorId, env, handler)
    }

    override fun processTerminating(executorId: String, env: ExecutionEnvironment, handler: ProcessHandler) {
        super.processTerminating(executorId, env, handler)
    }

    override fun processTerminated(
        executorId: String,
        env: ExecutionEnvironment,
        handler: ProcessHandler,
        exitCode: Int
    ) {
        super.processTerminated(executorId, env, handler, exitCode)
    }

}

internal class ESExecutionTargetListener: ExecutionTargetListener {
    override fun activeTargetChanged(newTarget: ExecutionTarget) {
        TODO("Not yet implemented")
    }

}

internal class ESRunManagerListener: RunManagerListener {
    override fun runConfigurationSelected(settings: RunnerAndConfigurationSettings?) {
        super.runConfigurationSelected(settings)
    }

    override fun beforeRunTasksChanged() {
        super.beforeRunTasksChanged()
    }

    override fun runConfigurationAdded(settings: RunnerAndConfigurationSettings) {
        super.runConfigurationAdded(settings)
    }

    override fun runConfigurationRemoved(settings: RunnerAndConfigurationSettings) {
        super.runConfigurationRemoved(settings)
    }

    override fun runConfigurationChanged(settings: RunnerAndConfigurationSettings, existingId: String?) {
        super.runConfigurationChanged(settings, existingId)
    }

    override fun beginUpdate() {
        super.beginUpdate()
    }

    override fun endUpdate() {
        super.endUpdate()
    }

    override fun stateLoaded(runManager: RunManager, isFirstLoadState: Boolean) {
        super.stateLoaded(runManager, isFirstLoadState)
    }

}

internal class ESRunDashboardListener: RunDashboardListener {
    override fun configurationChanged(configuration: RunConfiguration, withStructure: Boolean) {
        TODO("Not yet implemented")
    }

}

internal class ESElevationSettingsListener: ElevationSettingsListener {

}

internal class ESRWSlotsConfigurationListener: RWSlotsConfigurationListener {
    override fun configurationChanged(slotId: String, configuration: RunnerAndConfigurationSettings?) {
        TODO("Not yet implemented")
    }

    override fun slotsConfigurationChanged(slotConfigurations: Map<String, RunnerAndConfigurationSettings?>) {
        TODO("Not yet implemented")
    }

}

internal class ESServiceEventListener: ServiceEventListener {
    override fun handle(event: ServiceEventListener.ServiceEvent) {
        TODO("Not yet implemented")
    }

}

internal class ESSMTRunnerEventsListener: SMTRunnerEventsListener {
    override fun onTestingStarted(testsRoot: SMTestProxy.SMRootTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onTestingFinished(testsRoot: SMTestProxy.SMRootTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onTestsCountInSuite(count: Int) {
        TODO("Not yet implemented")
    }

    override fun onTestStarted(test: SMTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onTestFinished(test: SMTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onTestFailed(test: SMTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onTestIgnored(test: SMTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onSuiteFinished(suite: SMTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onSuiteStarted(suite: SMTestProxy) {
        TODO("Not yet implemented")
    }

    override fun onCustomProgressTestsCategory(categoryName: String?, testCount: Int) {
        TODO("Not yet implemented")
    }

    override fun onCustomProgressTestStarted() {
        TODO("Not yet implemented")
    }

    override fun onCustomProgressTestFailed() {
        TODO("Not yet implemented")
    }

    override fun onCustomProgressTestFinished() {
        TODO("Not yet implemented")
    }

    override fun onSuiteTreeNodeAdded(testProxy: SMTestProxy?) {
        TODO("Not yet implemented")
    }

    override fun onSuiteTreeStarted(suite: SMTestProxy?) {
        TODO("Not yet implemented")
    }

}

internal class ESRunContentWithExecutorListener: RunContentWithExecutorListener {
    override fun contentSelected(descriptor: RunContentDescriptor?, executor: Executor) {
        super.contentSelected(descriptor, executor)
    }

    override fun contentRemoved(descriptor: RunContentDescriptor?, executor: Executor) {
        super.contentRemoved(descriptor, executor)
    }

}

internal class ESFacetManagerListener: FacetManagerListener {
    override fun beforeFacetAdded(facet: Facet<*>) {
        super.beforeFacetAdded(facet)
    }

    override fun beforeFacetRemoved(facet: Facet<*>) {
        super.beforeFacetRemoved(facet)
    }

    override fun beforeFacetRenamed(facet: Facet<*>) {
        super.beforeFacetRenamed(facet)
    }

    override fun facetAdded(facet: Facet<*>) {
        super.facetAdded(facet)
    }

    override fun facetRenamed(facet: Facet<*>, oldName: String) {
        super.facetRenamed(facet, oldName)
    }

    override fun facetConfigurationChanged(facet: Facet<*>) {
        super.facetConfigurationChanged(facet)
    }

}

internal class ESFeaturesRegistryListener: FeaturesRegistryListener {
    override fun featureUsed(feature: FeatureDescriptor) {
        TODO("Not yet implemented")
    }

}

internal class ESFindModelListener: FindModelListener {
    override fun findNextModelChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESAppLifecycleListener: AppLifecycleListener {
    override fun appFrameCreated(commandLineArgs: MutableList<String>) {
        super.appFrameCreated(commandLineArgs)
    }

    override fun welcomeScreenDisplayed() {
        super.welcomeScreenDisplayed()
    }

    override fun appStarted() {
        super.appStarted()
    }

    override fun projectFrameClosed() {
        super.projectFrameClosed()
    }

    override fun projectOpenFailed() {
        super.projectOpenFailed()
    }

    override fun appClosing() {
        super.appClosing()
    }

    override fun appWillBeClosed(isRestart: Boolean) {
        super.appWillBeClosed(isRestart)
    }

}

internal class ESFrameStateListener: FrameStateListener {
    override fun onFrameDeactivated(frame: IdeFrame) {
        super.onFrameDeactivated(frame)
    }

    override fun onFrameActivated(frame: IdeFrame) {
        super.onFrameActivated(frame)
    }

}

internal class ESPowerSaveModeListener: PowerSaveModeListener {
    override fun powerSaveStateChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESRecentProjectsChange: RecentProjectsChange {
    override fun change() {
        TODO("Not yet implemented")
    }

}

internal class ESSaveAndSyncHandlerListener: SaveAndSyncHandlerListener {
    override fun beforeRefresh() {
        super.beforeRefresh()
    }

    override fun beforeSave(task: SaveAndSyncHandler.SaveTask?, forceExecuteImmediately: Boolean) {
        super.beforeSave(task, forceExecuteImmediately)
    }

}

internal class ESSETabSwitcherListener: SETabSwitcherListener {
    override fun tabSwitched(event: SETabSwitcherListener.SETabSwitchedEvent) {
        TODO("Not yet implemented")
    }

}

internal class ESSearchListener: SearchListener {
    override fun elementsAdded(list: MutableList<out SearchEverywhereFoundElementInfo>) {
        TODO("Not yet implemented")
    }

    override fun elementsRemoved(list: MutableList<out SearchEverywhereFoundElementInfo>) {
        TODO("Not yet implemented")
    }

    override fun contributorWaits(contributor: SearchEverywhereContributor<*>) {
        TODO("Not yet implemented")
    }

    override fun contributorFinished(contributor: SearchEverywhereContributor<*>, hasMore: Boolean) {
        TODO("Not yet implemented")
    }

    override fun searchFinished(hasMoreContributors: MutableMap<SearchEverywhereContributor<*>, Boolean>) {
        TODO("Not yet implemented")
    }

    override fun searchStarted(pattern: String, contributors: MutableCollection<out SearchEverywhereContributor<*>>) {
        TODO("Not yet implemented")
    }

}

internal class ESBookmarksListener: BookmarksListener {
    override fun groupsSorted() {
        super.groupsSorted()
    }

    override fun groupAdded(group: BookmarkGroup) {
        super.groupAdded(group)
    }

    override fun groupRemoved(group: BookmarkGroup) {
        super.groupRemoved(group)
    }

    override fun groupRenamed(group: BookmarkGroup) {
        super.groupRenamed(group)
    }

    override fun bookmarksSorted(group: BookmarkGroup) {
        super.bookmarksSorted(group)
    }

    override fun bookmarkAdded(group: BookmarkGroup, bookmark: Bookmark) {
        super.bookmarkAdded(group, bookmark)
    }

    override fun bookmarkRemoved(group: BookmarkGroup, bookmark: Bookmark) {
        super.bookmarkRemoved(group, bookmark)
    }

    override fun bookmarkChanged(group: BookmarkGroup, bookmark: Bookmark) {
        super.bookmarkChanged(group, bookmark)
    }

    override fun bookmarkTypeChanged(bookmark: Bookmark) {
        super.bookmarkTypeChanged(bookmark)
    }

    override fun defaultGroupChanged(oldGroup: BookmarkGroup?, newGroup: BookmarkGroup?) {
        super.defaultGroupChanged(oldGroup, newGroup)
    }

    override fun structureChanged(node: Any?) {
        super.structureChanged(node)
    }

}

internal class ESbookmarksBookmarksListener: bookmarksBookmarksListener {
    override fun bookmarkAdded(b: com.intellij.ide.bookmarks.Bookmark) {
        super.bookmarkAdded(b)
    }

    override fun bookmarkRemoved(b: com.intellij.ide.bookmarks.Bookmark) {
        super.bookmarkRemoved(b)
    }

    override fun bookmarkChanged(b: com.intellij.ide.bookmarks.Bookmark) {
        super.bookmarkChanged(b)
    }

    override fun bookmarksOrderChanged() {
        super.bookmarksOrderChanged()
    }

}

internal class ESBatchFileChangeListener: BatchFileChangeListener {
    override fun batchChangeStarted(project: Project, activityName: String?) {
        super.batchChangeStarted(project, activityName)
    }

    override fun batchChangeCompleted(project: Project) {
        super.batchChangeCompleted(project)
    }

}

internal class ESDataSharingSettingsChangeListener: DataSharingSettingsChangeListener {
    override fun consentWritten() {
        TODO("Not yet implemented")
    }

}

internal class ESLightEditServiceListener: LightEditServiceListener {
    override fun lightEditWindowOpened(project: Project) {
        super.lightEditWindowOpened(project)
    }

    override fun lightEditWindowClosed(project: Project) {
        super.lightEditWindowClosed(project)
    }

}

internal class ESDynamicPluginListener: DynamicPluginListener {
    override fun beforePluginLoaded(pluginDescriptor: IdeaPluginDescriptor) {
        super.beforePluginLoaded(pluginDescriptor)
    }

    override fun beforePluginUnload(pluginDescriptor: IdeaPluginDescriptor, isUpdate: Boolean) {
        super.beforePluginUnload(pluginDescriptor, isUpdate)
    }

    override fun checkUnloadPlugin(pluginDescriptor: IdeaPluginDescriptor) {
        super.checkUnloadPlugin(pluginDescriptor)
    }

    override fun pluginLoaded(pluginDescriptor: IdeaPluginDescriptor) {
        super.pluginLoaded(pluginDescriptor)
    }

    override fun pluginUnloaded(pluginDescriptor: IdeaPluginDescriptor, isUpdate: Boolean) {
        super.pluginUnloaded(pluginDescriptor, isUpdate)
    }

}

internal class ESPluginRepositoryAuthListener: PluginRepositoryAuthListener {
    override fun authenticationChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESProjectViewListener: ProjectViewListener {
    override fun paneShown(current: AbstractProjectViewPane, previous: AbstractProjectViewPane?) {
        super.paneShown(current, previous)
    }

}

internal class ESTrustedProjectsListener: TrustedProjectsListener {
    override fun onProjectTrusted(locatedProject: TrustedProjectsLocator.LocatedProject) {
        super.onProjectTrusted(locatedProject)
    }

    override fun onProjectTrusted(project: Project) {
        super.onProjectTrusted(project)
    }

    override fun onProjectTrustedFromNotification(project: Project) {
        super.onProjectTrustedFromNotification(project)
    }

    override fun onProjectUntrusted(locatedProject: TrustedProjectsLocator.LocatedProject) {
        super.onProjectUntrusted(locatedProject)
    }

    override fun onProjectUntrusted(project: Project) {
        super.onProjectUntrusted(project)
    }

}

internal class ESLafManagerListener: LafManagerListener {
    override fun lookAndFeelChanged(source: LafManager) {
        TODO("Not yet implemented")
    }

}

internal class ESUISettingsListener: UISettingsListener {
    override fun uiSettingsChanged(uiSettings: UISettings) {
        TODO("Not yet implemented")
    }

}

internal class ESVirtualFileAppearanceListener: VirtualFileAppearanceListener {
    override fun virtualFileAppearanceChanged(virtualFile: VirtualFile) {
        TODO("Not yet implemented")
    }

}

internal class ESCustomActionsListener: CustomActionsListener {
    override fun schemaChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESComponentHighlightingListener: ComponentHighlightingListener {
    override fun highlight(component: JComponent, searchString: String) {
        TODO("Not yet implemented")
    }

}

internal class ESFileStructurePopupListener: FileStructurePopupListener {
    override fun stateChanged(opened: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isLoading(isLoading: Boolean) {
        TODO("Not yet implemented")
    }

}

internal class ESEventLogConfigOptionsListener: EventLogConfigOptionsListener {
    override fun optionsChanged(recorderId: String, options: MutableMap<String, String>) {
        TODO("Not yet implemented")
    }

}

internal class ESExternalResourceListener: ExternalResourceListener {
    override fun externalResourceChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESEventListener: EventListener {
    override fun modelChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESNotifications: Notifications {
    override fun notify(notification: com.intellij.notification.Notification) {
        super.notify(notification)
    }

    override fun register(groupDisplayName: String, defaultDisplayType: NotificationDisplayType) {
        super.register(groupDisplayName, defaultDisplayType)
    }

    override fun register(groupDisplayName: String, defaultDisplayType: NotificationDisplayType, shouldLog: Boolean) {
        super.register(groupDisplayName, defaultDisplayType, shouldLog)
    }

    override fun register(
        groupDisplayName: String,
        defaultDisplayType: NotificationDisplayType,
        shouldLog: Boolean,
        shouldReadAloud: Boolean
    ) {
        super.register(groupDisplayName, defaultDisplayType, shouldLog, shouldReadAloud)
    }

}

internal class ESAnActionListener: AnActionListener {
    override fun beforeActionPerformed(action: AnAction, event: AnActionEvent) {
        super.beforeActionPerformed(action, event)
    }

    override fun afterActionPerformed(action: AnAction, event: AnActionEvent, result: AnActionResult) {
        super.afterActionPerformed(action, event, result)
    }

    override fun beforeEditorTyping(c: Char, dataContext: DataContext) {
        super.beforeEditorTyping(c, dataContext)
    }

    override fun afterEditorTyping(c: Char, dataContext: DataContext) {
        super.afterEditorTyping(c, dataContext)
    }

    override fun beforeShortcutTriggered(shortcut: Shortcut, actions: MutableList<AnAction>, dataContext: DataContext) {
        super.beforeShortcutTriggered(shortcut, actions, dataContext)
    }

}

internal class ESToolbarActionsUpdatedListener: ToolbarActionsUpdatedListener {
    override fun actionsUpdated() {
        TODO("Not yet implemented")
    }

}

internal class ESApplicationActivationListener: ApplicationActivationListener {
    override fun applicationActivated(ideFrame: IdeFrame) {
        super.applicationActivated(ideFrame)
    }

    override fun applicationDeactivated(ideFrame: IdeFrame) {
        super.applicationDeactivated(ideFrame)
    }

    override fun delayedApplicationDeactivated(ideFrame: Window) {
        super.delayedApplicationDeactivated(ideFrame)
    }

}

internal class ESCommandListener: CommandListener {
    override fun commandStarted(event: CommandEvent) {
        super.commandStarted(event)
    }

    override fun beforeCommandFinished(event: CommandEvent) {
        super.beforeCommandFinished(event)
    }

    override fun commandFinished(event: CommandEvent) {
        super.commandFinished(event)
    }

    override fun undoTransparentActionStarted() {
        super.undoTransparentActionStarted()
    }

    override fun beforeUndoTransparentActionFinished() {
        super.beforeUndoTransparentActionFinished()
    }

    override fun undoTransparentActionFinished() {
        super.undoTransparentActionFinished()
    }

}

internal class ESLatencyListener: LatencyListener {
    override fun recordTypingLatency(editor: Editor, action: String?, latencyMs: Long) {
        TODO("Not yet implemented")
    }

}

internal class ESEditorColorsListener: EditorColorsListener {
    override fun globalSchemeChange(scheme: EditorColorsScheme?) {
        TODO("Not yet implemented")
    }

}

internal class ESEditorColorsManagerListener: EditorColorsManagerListener {
    override fun schemesReloaded() {
        TODO("Not yet implemented")
    }

}

internal class ESExternalSystemProjectNotificationAwareListener: ExternalSystemProjectNotificationAwareListener {
    override fun onNotificationChanged(project: Project) {
        super.onNotificationChanged(project)
    }

}

internal class ESProjectDataImportListener: ProjectDataImportListener {
    override fun onImportStarted(projectPath: String?) {
        super.onImportStarted(projectPath)
    }

    override fun onImportFinished(projectPath: String?) {
        super.onImportFinished(projectPath)
    }

    override fun onImportFailed(projectPath: String?) {
        super.onImportFailed(projectPath)
    }

    override fun onImportFailed(projectPath: String?, t: Throwable) {
        super.onImportFailed(projectPath, t)
    }

    override fun onFinalTasksStarted(projectPath: String?) {
        super.onFinalTasksStarted(projectPath)
    }

    override fun onFinalTasksFinished(projectPath: String?) {
        super.onFinalTasksFinished(projectPath)
    }

}

internal class ESFileDocumentManagerListener: FileDocumentManagerListener {
    override fun beforeAllDocumentsSaving() {
        super.beforeAllDocumentsSaving()
    }

    override fun beforeAnyDocumentSaving(document: Document, explicit: Boolean) {
        super.beforeAnyDocumentSaving(document, explicit)
    }

    override fun beforeDocumentSaving(document: Document) {
        super.beforeDocumentSaving(document)
    }

    override fun beforeFileContentReload(file: VirtualFile, document: Document) {
        super.beforeFileContentReload(file, document)
    }

    override fun fileWithNoDocumentChanged(file: VirtualFile) {
        super.fileWithNoDocumentChanged(file)
    }

    override fun fileContentReloaded(file: VirtualFile, document: Document) {
        super.fileContentReloaded(file, document)
    }

    override fun fileContentLoaded(file: VirtualFile, document: Document) {
        super.fileContentLoaded(file, document)
    }

    override fun unsavedDocumentDropped(document: Document) {
        super.unsavedDocumentDropped(document)
    }

    override fun unsavedDocumentsDropped() {
        super.unsavedDocumentsDropped()
    }

    override fun afterDocumentUnbound(file: VirtualFile, document: Document) {
        super.afterDocumentUnbound(file, document)
    }

}

internal class ESBefore: Before {
    override fun beforeFileOpened(source: FileEditorManager, file: VirtualFile) {
        super.beforeFileOpened(source, file)
    }

    override fun beforeFileClosed(source: FileEditorManager, file: VirtualFile) {
        super.beforeFileClosed(source, file)
    }

}

internal class ESFileEditorManagerListener: FileEditorManagerListener {
    override fun fileOpenedSync(
        source: FileEditorManager,
        file: VirtualFile,
        editors: Pair<Array<FileEditor>, Array<FileEditorProvider>>
    ) {
        super.fileOpenedSync(source, file, editors)
    }

    override fun fileOpenedSync(
        source: FileEditorManager,
        file: VirtualFile,
        editorsWithProviders: MutableList<FileEditorWithProvider>
    ) {
        super.fileOpenedSync(source, file, editorsWithProviders)
    }

    override fun fileOpened(source: FileEditorManager, file: VirtualFile) {
        super.fileOpened(source, file)
    }

    override fun fileClosed(source: FileEditorManager, file: VirtualFile) {
        super.fileClosed(source, file)
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        super.selectionChanged(event)
    }

}

internal class ESFileOpenedSyncListener: FileOpenedSyncListener {
    override fun fileOpenedSync(
        source: FileEditorManager,
        file: VirtualFile,
        editorsWithProviders: List<FileEditorWithProvider>
    ) {
        super.fileOpenedSync(source, file, editorsWithProviders)
    }

}

internal class ESRecentPlacesListener: RecentPlacesListener {
    override fun recentPlaceAdded(changePlace: IdeDocumentHistoryImpl.PlaceInfo, isChanged: Boolean) {
        TODO("Not yet implemented")
    }

    override fun recentPlaceRemoved(changePlace: IdeDocumentHistoryImpl.PlaceInfo, isChanged: Boolean) {
        TODO("Not yet implemented")
    }

}

internal class ESFileTypeListener: FileTypeListener {
    override fun beforeFileTypesChanged(event: FileTypeEvent) {
        super.beforeFileTypesChanged(event)
    }

    override fun fileTypesChanged(event: FileTypeEvent) {
        super.fileTypesChanged(event)
    }

}

internal class ESKeymapManagerListener: KeymapManagerListener {
    override fun keymapAdded(keymap: Keymap) {
        super.keymapAdded(keymap)
    }

    override fun keymapRemoved(keymap: Keymap) {
        super.keymapRemoved(keymap)
    }

    override fun activeKeymapChanged(keymap: Keymap?) {
        super.activeKeymapChanged(keymap)
    }

    override fun shortcutChanged(keymap: Keymap, actionId: String) {
        super.shortcutChanged(keymap, actionId)
    }

    override fun shortcutChanged(keymap: Keymap, actionId: String, fromSettings: Boolean) {
        super.shortcutChanged(keymap, actionId, fromSettings)
    }

}

internal class ESKeymapListener: KeymapListener {
    override fun quickListRenamed(oldQuickList: QuickList, newQuickList: QuickList) {
        TODO("Not yet implemented")
    }

    override fun processCurrentKeymapChanged(ids: Array<out QuickList>) {
        TODO("Not yet implemented")
    }

    override fun processCurrentKeymapChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESExternalUpdateRequest: ExternalUpdateRequest {
    override fun requestUpdate(configurable: Configurable) {
        TODO("Not yet implemented")
    }

}

internal class ESProgressManagerListener: ProgressManagerListener {
    override fun beforeTaskStart(task: Task, indicator: ProgressIndicator) {
        super.beforeTaskStart(task, indicator)
    }

    override fun afterTaskStart(task: Task, indicator: ProgressIndicator) {
        super.afterTaskStart(task, indicator)
    }

    override fun beforeTaskFinished(task: Task) {
        super.beforeTaskFinished(task)
    }

    override fun afterTaskFinished(task: Task) {
        super.afterTaskFinished(task)
    }

}

internal class ESSuspenderListener: SuspenderListener {
    override fun suspendableProgressAppeared(suspender: ProgressSuspender) {
        super.suspendableProgressAppeared(suspender)
    }

    override fun suspendedStatusChanged(suspender: ProgressSuspender) {
        super.suspendedStatusChanged(suspender)
    }

}

internal class ESProgressWindowListener: ProgressWindowListener {
    override fun progressWindowCreated(pw: ProgressWindow) {
        TODO("Not yet implemented")
    }

}

internal class ESBaseProjectDirectoriesListener: BaseProjectDirectoriesListener {
    override fun changed(project: Project, diff: BaseProjectDirectoriesDiff) {
        TODO("Not yet implemented")
    }

}

internal class ESDumbModeListener: DumbModeListener {
    override fun enteredDumbMode() {
        super.enteredDumbMode()
    }

    override fun exitDumbMode() {
        super.exitDumbMode()
    }

}

internal class ESModuleListener: ModuleListener {
    override fun moduleAdded(project: Project, module: Module) {
        super.moduleAdded(project, module)
    }

    override fun modulesAdded(project: Project, modules: MutableList<out Module>) {
        super.modulesAdded(project, modules)
    }

    override fun beforeModuleRemoved(project: Project, module: Module) {
        super.beforeModuleRemoved(project, module)
    }

    override fun moduleRemoved(project: Project, module: Module) {
        super.moduleRemoved(project, module)
    }

    override fun modulesRenamed(
        project: Project,
        modules: MutableList<out Module>,
        oldNameProvider: Function<in Module, String>
    ) {
        super.modulesRenamed(project, modules, oldNameProvider)
    }

}

internal class ESProjectCloseListener: ProjectCloseListener {
    override fun projectClosed(project: Project) {
        super.projectClosed(project)
    }

    override fun projectClosing(project: Project) {
        super.projectClosing(project)
    }

    override fun projectClosingBeforeSave(project: Project) {
        super.projectClosingBeforeSave(project)
    }

}

internal class ESProjectManagerListener: ProjectManagerListener {
    override fun projectClosed(project: Project) {
        super.projectClosed(project)
    }

    override fun projectClosing(project: Project) {
        super.projectClosing(project)
    }

    override fun projectClosingBeforeSave(project: Project) {
        super.projectClosingBeforeSave(project)
    }

}

internal class ESProjectLifecycleListener: ProjectLifecycleListener {

}

internal class ESProjectJdkTableListener: ProjectJdkTableListener {
    override fun jdkAdded(jdk: Sdk) {
        super.jdkAdded(jdk)
    }

    override fun jdkRemoved(jdk: Sdk) {
        super.jdkRemoved(jdk)
    }

    override fun jdkNameChanged(jdk: Sdk, previousName: String) {
        super.jdkNameChanged(jdk, previousName)
    }

}

internal class ESAdditionalLibraryRootsListener: AdditionalLibraryRootsListener {
    override fun libraryRootsChanged(
        presentableLibraryName: String?,
        oldRoots: MutableCollection<out VirtualFile>,
        newRoots: MutableCollection<out VirtualFile>,
        libraryNameForDebug: String
    ) {
        TODO("Not yet implemented")
    }

}

internal class ESModuleRootListener: ModuleRootListener {
    override fun beforeRootsChange(event: ModuleRootEvent) {
        super.beforeRootsChange(event)
    }

    override fun rootsChanged(event: ModuleRootEvent) {
        super.rootsChanged(event)
    }

}

internal class ESRegistryValueListener: RegistryValueListener {
    override fun beforeValueChanged(value: RegistryValue) {
        super.beforeValueChanged(value)
    }

    override fun afterValueChanged(value: RegistryValue) {
        super.afterValueChanged(value)
    }

}

internal class ESBranchChangeListener: BranchChangeListener {
    override fun branchWillChange(branchName: String) {
        TODO("Not yet implemented")
    }

    override fun branchHasChanged(branchName: String) {
        TODO("Not yet implemented")
    }

}

internal class ESBranchRenameListener: BranchRenameListener {
    override fun branchNameChanged(root: VirtualFile, oldName: String, newName: String) {
        TODO("Not yet implemented")
    }

}

internal class ESFileStatusListener: FileStatusListener {
    override fun fileStatusesChanged() {
        super.fileStatusesChanged()
    }

    override fun fileStatusChanged(virtualFile: VirtualFile) {
        super.fileStatusChanged(virtualFile)
    }

}

internal class ESPluginVcsMappingListener: PluginVcsMappingListener {
    override fun directoryMappingChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESVcsMappingListener: VcsMappingListener {
    override fun directoryMappingChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESChangeListAvailabilityListener: ChangeListAvailabilityListener {
    override fun onBefore() {
        super.onBefore()
    }

    override fun onAfter() {
        super.onAfter()
    }

}

internal class ESChangeListListener: ChangeListListener {
    override fun changeListAdded(list: ChangeList?) {
        super.changeListAdded(list)
    }

    override fun changeListRemoved(list: ChangeList?) {
        super.changeListRemoved(list)
    }

    override fun changeListChanged(list: ChangeList?) {
        super.changeListChanged(list)
    }

    override fun changeListDataChanged(list: ChangeList) {
        super.changeListDataChanged(list)
    }

    override fun changeListRenamed(list: ChangeList?, oldName: String?) {
        super.changeListRenamed(list, oldName)
    }

    override fun changeListCommentChanged(list: ChangeList?, oldComment: String?) {
        super.changeListCommentChanged(list, oldComment)
    }

    override fun defaultListChanged(oldDefaultList: ChangeList?, newDefaultList: ChangeList?) {
        super.defaultListChanged(oldDefaultList, newDefaultList)
    }

    override fun defaultListChanged(oldDefaultList: ChangeList?, newDefaultList: ChangeList?, automatic: Boolean) {
        super.defaultListChanged(oldDefaultList, newDefaultList, automatic)
    }

    override fun changesAdded(changes: MutableCollection<out Change>?, toList: ChangeList?) {
        super.changesAdded(changes, toList)
    }

    override fun changesRemoved(changes: MutableCollection<out Change>?, fromList: ChangeList?) {
        super.changesRemoved(changes, fromList)
    }

    override fun changesMoved(changes: MutableCollection<out Change>?, fromList: ChangeList?, toList: ChangeList?) {
        super.changesMoved(changes, fromList, toList)
    }

    override fun allChangeListsMappingsChanged() {
        super.allChangeListsMappingsChanged()
    }

    override fun changedFileStatusChanged() {
        super.changedFileStatusChanged()
    }

    override fun changedFileStatusChanged(upToDate: Boolean) {
        super.changedFileStatusChanged(upToDate)
    }

    override fun unchangedFileStatusChanged() {
        super.unchangedFileStatusChanged()
    }

    override fun unchangedFileStatusChanged(upToDate: Boolean) {
        super.unchangedFileStatusChanged(upToDate)
    }

    override fun changeListUpdateDone() {
        super.changeListUpdateDone()
    }

    override fun changeListAvailabilityChanged() {
        super.changeListAvailabilityChanged()
    }

}

internal class ESChangesViewModifierListener: ChangesViewModifierListener {
    override fun updated() {
        TODO("Not yet implemented")
    }

}

internal class ESChangesViewWorkflowListener: ChangesViewWorkflowListener {
    override fun commitWorkflowChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESLocalChangeListsLoadedListener: LocalChangeListsLoadedListener {
    override fun processLoadedLists(lists: MutableList<LocalChangeList>) {
        TODO("Not yet implemented")
    }

}

internal class ESVcsAnnotationRefresher: VcsAnnotationRefresher {
    override fun dirtyUnder(file: VirtualFile?) {
        TODO("Not yet implemented")
    }

    override fun dirty(currentRevision: BaseRevision) {
        TODO("Not yet implemented")
    }

    override fun dirty(path: String) {
        TODO("Not yet implemented")
    }

    override fun configurationChanged(key: VcsKey) {
        TODO("Not yet implemented")
    }

}

internal class ESVcsFreezingProcessListener: VcsFreezingProcessListener {
    override fun onFreeze() {
        super.onFreeze()
    }

    override fun onUnfreeze() {
        super.onUnfreeze()
    }

}

internal class ESVcsManagedFilesHolderListener: VcsManagedFilesHolderListener {
    override fun updatingModeChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESCommittedChangesListener: CommittedChangesListener {
    override fun changesLoaded(location: RepositoryLocation, changes: MutableList<CommittedChangeList>) {
        super.changesLoaded(location, changes)
    }

    override fun incomingChangesUpdated(receivedChanges: MutableList<CommittedChangeList>?) {
        super.incomingChangesUpdated(receivedChanges)
    }

    override fun changesCleared() {
        super.changesCleared()
    }

    override fun refreshErrorStatusChanged(lastError: VcsException?) {
        super.refreshErrorStatusChanged(lastError)
    }

}

internal class ESCommittedChangesReloadListener: CommittedChangesReloadListener {
    override fun itemsReloaded() {
        TODO("Not yet implemented")
    }

    override fun emptyRefresh() {
        TODO("Not yet implemented")
    }

}

internal class ESDetailedNotification: DetailedNotification {
    override fun execute(project: Project, vcsRoot: VirtualFile?, cachedList: MutableList<CommittedChangeList>) {
        TODO("Not yet implemented")
    }

}

internal class ESNotification: Notification {
    override fun execute(project: Project, vcsRoot: VirtualFile) {
        TODO("Not yet implemented")
    }

}

internal class ESShelveChangesManagerListener: ShelveChangesManagerListener {
    override fun shelvedListsChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESChangesViewContentManagerListener: ChangesViewContentManagerListener {
    override fun toolWindowMappingChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESVcsActivationListener: VcsActivationListener {
    override fun vcsesActivated(activeVcses: MutableList<AbstractVcs>) {
        TODO("Not yet implemented")
    }

}

internal class ESLineStatusTrackerSettingListener: LineStatusTrackerSettingListener {
    override fun settingsUpdated() {
        TODO("Not yet implemented")
    }

}

internal class ESVcsBaseContentProviderListener: VcsBaseContentProviderListener {
    override fun onFileBaseContentChanged(file: VirtualFile) {
        TODO("Not yet implemented")
    }

    override fun onEverythingChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESUpdatedFilesListener: UpdatedFilesListener {
    override fun consume(t: MutableSet<String>?) {
        TODO("Not yet implemented")
    }

}

internal class ESVirtualFileManagerListener: VirtualFileManagerListener {
    override fun beforeRefreshStart(asynchronous: Boolean) {
        super.beforeRefreshStart(asynchronous)
    }

    override fun afterRefreshFinish(asynchronous: Boolean) {
        super.afterRefreshFinish(asynchronous)
    }

}

internal class ESEncodingManagerListener: EncodingManagerListener {
    override fun propertyChanged(document: Document?, propertyName: String, oldValue: Any?, newValue: Any?) {
        TODO("Not yet implemented")
    }

}

internal class ESBulkFileListener: BulkFileListener {
    override fun before(events: MutableList<out VFileEvent>) {
        super.before(events)
    }

    override fun after(events: MutableList<out VFileEvent>) {
        super.after(events)
    }

}

internal class ESVirtualFilePointerListener: VirtualFilePointerListener {
    override fun beforeValidityChanged(pointers: Array<out VirtualFilePointer>) {
        super.beforeValidityChanged(pointers)
    }

    override fun validityChanged(pointers: Array<out VirtualFilePointer>) {
        super.validityChanged(pointers)
    }

}

internal class ESStatusBarInfo: StatusBarInfo {
    override fun setInfo(s: String?) {
        TODO("Not yet implemented")
    }

    override fun setInfo(s: String?, requestor: String?) {
        TODO("Not yet implemented")
    }

    override fun getInfo(): String {
        TODO("Not yet implemented")
    }

}

internal class ESToolWindowManagerListener: ToolWindowManagerListener {
    override fun toolWindowRegistered(id: String) {
        super.toolWindowRegistered(id)
    }

    override fun toolWindowsRegistered(ids: MutableList<String>, toolWindowManager: ToolWindowManager) {
        super.toolWindowsRegistered(ids, toolWindowManager)
    }

    override fun toolWindowUnregistered(id: String, toolWindow: ToolWindow) {
        super.toolWindowUnregistered(id, toolWindow)
    }

    override fun stateChanged(toolWindowManager: ToolWindowManager) {
        super.stateChanged(toolWindowManager)
    }

    override fun stateChanged(
        toolWindowManager: ToolWindowManager,
        changeType: ToolWindowManagerListener.ToolWindowManagerEventType
    ) {
        super.stateChanged(toolWindowManager, changeType)
    }

    override fun stateChanged(
        toolWindowManager: ToolWindowManager,
        toolWindow: ToolWindow,
        changeType: ToolWindowManagerListener.ToolWindowManagerEventType
    ) {
        super.stateChanged(toolWindowManager, toolWindow, changeType)
    }

    override fun stateChanged() {
        super.stateChanged()
    }

    override fun toolWindowShown(toolWindow: ToolWindow) {
        super.toolWindowShown(toolWindow)
    }

}

internal class ESTitleInfoProviderListener: TitleInfoProviderListener {
    override fun configurationChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESBalloonNotificationListener: BalloonNotificationListener {
    override fun notificationsChanged(types: MutableList<NotificationType>?) {
        TODO("Not yet implemented")
    }

}

internal class ESWelcomeScreenComponentListener: WelcomeScreenComponentListener {
    override fun attachComponent(componentToShow: Component, onDone: Runnable?) {
        TODO("Not yet implemented")
    }

    override fun detachComponent(componentToDetach: Component, onDone: Runnable?) {
        TODO("Not yet implemented")
    }

}

internal class ESCloneProjectListener: CloneProjectListener {
    override fun onCloneAdded(progressIndicator: ProgressIndicatorEx, taskInfo: TaskInfo) {
        super.onCloneAdded(progressIndicator, taskInfo)
    }

    override fun onCloneCanceled() {
        super.onCloneCanceled()
    }

    override fun onCloneFailed() {
        super.onCloneFailed()
    }

    override fun onCloneRemoved() {
        super.onCloneRemoved()
    }

    override fun onCloneSuccess() {
        super.onCloneSuccess()
    }

}

internal class ESCourseDeletedListener: CourseDeletedListener {
    override fun courseDeleted(course: CourseInfo) {
        TODO("Not yet implemented")
    }

}

internal class ESModuleAttachListener: ModuleAttachListener {
    override fun afterAttach(
        module: Module,
        primaryModule: Module?,
        imlFile: Path,
        tasks: MutableList<suspend () -> Unit>
    ) {
        super.afterAttach(module, primaryModule, imlFile, tasks)
    }

    override fun beforeDetach(module: Module) {
        super.beforeDetach(module)
    }

}

internal class ESProblemListener: ProblemListener {
    override fun problemsAppeared(file: VirtualFile) {
        super.problemsAppeared(file)
    }

    override fun problemsChanged(file: VirtualFile) {
        super.problemsChanged(file)
    }

    override fun problemsDisappeared(file: VirtualFile) {
        super.problemsDisappeared(file)
    }

}

internal class ESProfileChangeAdapter: ProfileChangeAdapter {
    override fun profileChanged(profile: InspectionProfile) {
        super.profileChanged(profile)
    }

    override fun profileActivated(oldProfile: InspectionProfile?, profile: InspectionProfile?) {
        super.profileActivated(oldProfile, profile)
    }

    override fun profilesInitialized() {
        super.profilesInitialized()
    }

}

internal class ESPsiDocumentListener: PsiDocumentListener {
    override fun documentCreated(document: Document, psiFile: PsiFile?, project: Project) {
        TODO("Not yet implemented")
    }

    override fun fileCreated(file: PsiFile, document: Document) {
        super.fileCreated(file, document)
    }

}

internal class ESCodeStyleManagerListener: CodeStyleManagerListener {
    override fun beforeReformatText(file: PsiFile) {
        TODO("Not yet implemented")
    }

    override fun afterReformatText(file: PsiFile) {
        TODO("Not yet implemented")
    }

}

internal class ESCodeStyleSettingsListener: CodeStyleSettingsListener {
    override fun codeStyleSettingsChanged(event: CodeStyleSettingsChangeEvent) {
        TODO("Not yet implemented")
    }

}

internal class ESAnyPsiChangeListener: AnyPsiChangeListener {
    override fun beforePsiChanged(isPhysical: Boolean) {
        super.beforePsiChanged(isPhysical)
    }

    override fun afterPsiChanged(isPhysical: Boolean) {
        super.afterPsiChanged(isPhysical)
    }

}

internal class ESPsiDocumentTransactionListener: PsiDocumentTransactionListener {
    override fun transactionStarted(document: Document, file: PsiFile) {
        TODO("Not yet implemented")
    }

}

internal class ESIndexChangeListener: IndexChangeListener {
    override fun onChangedForFileType(fileType: FileType) {
        TODO("Not yet implemented")
    }

}

internal class ESPsiModificationTrackerListener: PsiModificationTrackerListener {
    override fun modificationCountChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESRefactoringEventListener: RefactoringEventListener {
    override fun refactoringDone(refactoringId: String, afterData: RefactoringEventData?) {
        TODO("Not yet implemented")
    }

}

internal class ESRemoteMappingsListener: RemoteMappingsListener {
    override fun mappingsChanged(prefix: String, serverId: String) {
        TODO("Not yet implemented")
    }

    override fun mappingsChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESRemoteServerListener: RemoteServerListener {
    override fun serverAdded(server: RemoteServer<*>) {
        TODO("Not yet implemented")
    }

    override fun serverRemoved(server: RemoteServer<*>) {
        TODO("Not yet implemented")
    }

}

internal class ESServerConnectionListener: ServerConnectionListener {
    override fun onConnectionCreated(connection: ServerConnection<*>) {
        TODO("Not yet implemented")
    }

    override fun onConnectionStatusChanged(connection: ServerConnection<*>) {
        TODO("Not yet implemented")
    }

    override fun onDeploymentsChanged(connection: ServerConnection<*>) {
        TODO("Not yet implemented")
    }

}

internal class ESSpellCheckerEngineListener: SpellCheckerEngineListener {
    override fun onSpellerInitialized() {
        TODO("Not yet implemented")
    }

}

internal class ESProjectTaskListener: ProjectTaskListener {
    override fun started(context: ProjectTaskContext) {
        super.started(context)
    }

    override fun finished(result: ProjectTaskManager.Result) {
        super.finished(result)
    }

}

internal class ESDeferredIconListener: DeferredIconListener {
    override fun evaluated(deferred: DeferredIcon, result: Icon) {
        TODO("Not yet implemented")
    }

}

internal class ESToolWindowViewModelListener: ToolWindowViewModelListener {
    override fun toolWindowChanged(id: String) {
        TODO("Not yet implemented")
    }

    override fun toolWindowsChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESCommitModeListener: CommitModeListener {
    override fun commitModeChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESCommitModeManagerSettingsListener: CommitModeManagerSettingsListener {
    override fun settingsChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESProfileListener: ProfileListener {
    override fun profileChanged() {
        TODO("Not yet implemented")
    }

}

internal class ESProjectLogListener: ProjectLogListener {
    override fun logCreated(manager: VcsLogManager) {
        TODO("Not yet implemented")
    }

    override fun logDisposed(manager: VcsLogManager) {
        TODO("Not yet implemented")
    }

}

internal class ESJpsProjectLoadedListener: JpsProjectLoadedListener {
    override fun loaded() {
        TODO("Not yet implemented")
    }

}

internal class ESXDebuggerManagerListener: XDebuggerManagerListener {
    override fun processStarted(debugProcess: XDebugProcess) {
        super.processStarted(debugProcess)
    }

    override fun processStopped(debugProcess: XDebugProcess) {
        super.processStopped(debugProcess)
    }

    override fun currentSessionChanged(previousSession: XDebugSession?, currentSession: XDebugSession?) {
        super.currentSessionChanged(previousSession, currentSession)
    }

}

internal class ESXDependentBreakpointListener: XDependentBreakpointListener {
    override fun dependencySet(slave: XBreakpoint<*>, master: XBreakpoint<*>) {
        TODO("Not yet implemented")
    }

    override fun dependencyCleared(breakpoint: XBreakpoint<*>?) {
        TODO("Not yet implemented")
    }

}

internal class ESBreadcrumbsInitListener: BreadcrumbsInitListener {
    override fun breadcrumbsInitialized(wrapper: BreadcrumbsPanel, fileEditor: FileEditor, manager: FileEditorManager) {
        TODO("Not yet implemented")
    }

}

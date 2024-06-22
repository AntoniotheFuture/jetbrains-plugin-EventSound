package com.github.antoniothefuture.intellij_plugin_eventsound.listeners

import com.intellij.analysis.problemsView.ProblemsListener
import com.intellij.application.options.editor.EditorOptionsListener
import com.intellij.codeInsight.actions.ReaderModeListener
import com.intellij.codeInsight.codeVision.settings.CodeVisionSettings.CodeVisionSettingsListener
import com.intellij.codeInsight.completion.CompletionContributorListener
import com.intellij.codeInsight.completion.CompletionPhaseListener
import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer.DaemonListener
// Incompatible version
// import com.intellij.codeInsight.daemon.impl.EditorTracker.EditorTrackerListener
import com.intellij.codeInsight.daemon.impl.analysis.FileHighlightingSettingListener
import com.intellij.codeInsight.documentation.render.DocRenderItemManagerImpl.Listener
import com.intellij.codeInsight.hint.EditorHintListener
import com.intellij.codeInsight.hint.ExternalParameterInfoChangesProvider
import com.intellij.codeInsight.hints.InlayHintsSettings.SettingsListener
// Incompatible version
// import com.intellij.codeInsight.inline.completion.InlineCompletionInstallListener
import com.intellij.codeInsight.lookup.LookupManagerListener
import com.intellij.codeInsight.template.TemplateManagerListener
import com.intellij.codeInspection.ex.InspectListener
import com.intellij.configurationStore.BatchUpdateListener
import com.intellij.diagnostic.IdePerformanceListener
import com.intellij.diagnostic.RunnablesListener
import com.intellij.dvcs.branch.DvcsBranchManager.DvcsBranchManagerListener
import com.intellij.dvcs.repo.VcsRepositoryMappingListener
import com.intellij.execution.ExecutionListener
import com.intellij.execution.ExecutionTargetListener
import com.intellij.execution.RunManagerListener
import com.intellij.execution.dashboard.RunDashboardListener
// Incompatible version
// import com.intellij.execution.multilaunch.execution.messaging.ExecutionNotifier
import com.intellij.execution.process.elevation.settings.ElevationSettings.Listener as ElevationSettingsListener
import com.intellij.execution.runToolbar.data.RWSlotsConfigurationListener
import com.intellij.execution.services.ServiceEventListener
import com.intellij.execution.testframework.sm.runner.SMTRunnerEventsListener
import com.intellij.execution.ui.RunContentWithExecutorListener
// Incompatible version
// import com.intellij.execution.ui.RunToolbarPopup.Listener as RunToolbarPopupListener
import com.intellij.facet.FacetManagerListener
// Incompatible version
// import com.intellij.featureStatistics.FeatureStatisticsUpdateListener
import com.intellij.featureStatistics.FeaturesRegistryListener
import com.intellij.find.FindModelListener
import com.intellij.ide.AppLifecycleListener
import com.intellij.ide.FrameStateListener
import com.intellij.ide.PowerSaveMode.Listener as PowerSaveModeListener
import com.intellij.ide.RecentProjectsManager.RecentProjectsChange
import com.intellij.ide.SaveAndSyncHandlerListener
// Incompatible version
// import com.intellij.ide.actions.searcheverywhere.SEHeaderActionListener
import com.intellij.ide.actions.searcheverywhere.SETabSwitcherListener
import com.intellij.ide.actions.searcheverywhere.SearchListener
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
import com.intellij.ide.plugins.auth.PluginRepositoryAuthListener
// Incompatible version
// import com.intellij.ide.projectView.ProjectViewSelectionTopic.ProjectViewSelectionListener
import com.intellij.ide.projectView.impl.ProjectViewListener
import com.intellij.ide.trustedProjects.TrustedProjectsListener
import com.intellij.ide.ui.LafManagerListener
import com.intellij.ide.ui.UISettingsListener
import com.intellij.ide.ui.VirtualFileAppearanceListener
import com.intellij.ide.ui.customization.CustomActionsListener
import com.intellij.ide.ui.search.ComponentHighlightingListener
import com.intellij.ide.util.FileStructurePopupListener
// Incompatible version
// import com.intellij.ide.util.scopeChooser.ScopeEditorPanel.SettingsChangedListener
import com.intellij.internal.statistic.eventLog.EventLogConfigOptionsListener
import com.intellij.javaee.ExternalResourceListener
// Incompatible version
// import com.intellij.lang.documentation.ide.impl.DocumentationPopupListener
import com.intellij.notification.ActionCenter.EventListener
import com.intellij.notification.Notifications
import com.intellij.openapi.actionSystem.ex.AnActionListener
import com.intellij.openapi.actionSystem.impl.segmentedActionBar.ToolbarActionsUpdatedListener
import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.command.CommandListener
import com.intellij.openapi.editor.actionSystem.LatencyListener
import com.intellij.openapi.editor.colors.EditorColorsListener
import com.intellij.openapi.editor.colors.impl.EditorColorsManagerListener
import com.intellij.openapi.editor.ex.DocumentBulkUpdateListener
import com.intellij.openapi.externalSystem.autoimport.ExternalSystemProjectNotificationAware.Listener as ExternalSystemProjectNotificationAwareListener
import com.intellij.openapi.externalSystem.service.project.manage.ProjectDataImportListener
import com.intellij.openapi.fileEditor.FileDocumentManagerListener
import com.intellij.openapi.fileEditor.FileEditorManagerListener.Before
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.fileEditor.FileOpenedSyncListener
import com.intellij.openapi.fileEditor.impl.IdeDocumentHistoryImpl.RecentPlacesListener
import com.intellij.openapi.fileTypes.FileTypeListener
import com.intellij.openapi.keymap.KeymapManagerListener
import com.intellij.openapi.keymap.impl.ui.KeymapListener
// Incompatible version
// import com.intellij.openapi.options.advanced.AdvancedSettings.AdvancedSettingsChangeListener
import com.intellij.openapi.options.newEditor.ExternalUpdateRequest
// Incompatible version
// import com.intellij.openapi.options.newEditor.SettingsDialogListener
import com.intellij.openapi.progress.ProgressManagerListener
import com.intellij.openapi.progress.impl.ProgressSuspender.SuspenderListener
import com.intellij.openapi.progress.util.ProgressWindow.Listener as ProgressWindowListener
import com.intellij.openapi.project.BaseProjectDirectoriesListener
import com.intellij.openapi.project.DumbService.DumbModeListener
import com.intellij.openapi.project.ModuleListener
import com.intellij.openapi.project.ProjectCloseListener
import com.intellij.openapi.project.ProjectManagerListener
// Incompatible version
// import com.intellij.openapi.project.ProjectNameListener
import com.intellij.openapi.project.impl.ProjectLifecycleListener
import com.intellij.openapi.projectRoots.ProjectJdkTable.Listener as ProjectJdkTableListener
import com.intellij.openapi.roots.AdditionalLibraryRootsListener
import com.intellij.openapi.roots.ModuleRootListener
// Incompatible version
// import com.intellij.openapi.ui.popup.BalloonListener
import com.intellij.openapi.util.registry.RegistryValueListener
import com.intellij.openapi.vcs.BranchChangeListener
import com.intellij.openapi.vcs.BranchRenameListener
import com.intellij.openapi.vcs.FileStatusListener
import com.intellij.openapi.vcs.PluginVcsMappingListener
import com.intellij.openapi.vcs.VcsMappingListener
import com.intellij.openapi.vcs.changes.ChangeListAvailabilityListener
import com.intellij.openapi.vcs.changes.ChangeListListener
import com.intellij.openapi.vcs.changes.ChangesViewModifier.ChangesViewModifierListener
import com.intellij.openapi.vcs.changes.ChangesViewWorkflowManager.ChangesViewWorkflowListener
import com.intellij.openapi.vcs.changes.LocalChangeListsLoadedListener
import com.intellij.openapi.vcs.changes.VcsAnnotationRefresher
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
import com.intellij.openapi.vfs.VirtualFileManagerListener
import com.intellij.openapi.vfs.encoding.EncodingManagerListener
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.pointers.VirtualFilePointerListener
import com.intellij.openapi.wm.StatusBarInfo
import com.intellij.openapi.wm.ex.ToolWindowManagerListener
import com.intellij.openapi.wm.impl.TitleInfoProvider.TitleInfoProviderListener
import com.intellij.openapi.wm.impl.welcomeScreen.WelcomeBalloonLayoutImpl.BalloonNotificationListener
import com.intellij.openapi.wm.impl.welcomeScreen.WelcomeScreenComponentListener
import com.intellij.openapi.wm.impl.welcomeScreen.cloneableProjects.CloneableProjectsService.CloneProjectListener
import com.intellij.openapi.wm.impl.welcomeScreen.learnIde.coursesInProgress.CourseDeletedListener
import com.intellij.platform.ModuleAttachListener
// Incompatible version
// import com.intellij.platform.externalSystem.testFramework.TestExternalSystemSettingsListener
import com.intellij.problems.ProblemListener
import com.intellij.profile.ProfileChangeAdapter
import com.intellij.psi.PsiDocumentListener
import com.intellij.psi.codeStyle.CodeStyleManager.Listener as CodeStyleManagerListener
import com.intellij.psi.codeStyle.CodeStyleSettingsListener
import com.intellij.psi.impl.AnyPsiChangeListener
import com.intellij.psi.impl.PsiDocumentTransactionListener
import com.intellij.psi.search.FileTypeIndex.IndexChangeListener
import com.intellij.psi.util.PsiModificationTracker.Listener as PsiModificationTrackerListener
import com.intellij.refactoring.listeners.RefactoringEventListener
import com.intellij.remote.RemoteMappingsListener
import com.intellij.remoteServer.configuration.RemoteServerListener
import com.intellij.remoteServer.runtime.ServerConnectionListener
import com.intellij.spellchecker.engine.SpellCheckerEngineListener
import com.intellij.task.ProjectTaskListener
import com.intellij.ui.DeferredIconListener
import com.intellij.ui.viewModel.extraction.ToolWindowViewModelListener
// Removed
// import com.intellij.util.indexing.UnindexedFilesUpdaterListener
// Incompatible version
// import com.intellij.util.indexing.diagnostic.ProjectIndexingHistory.ProjectIndexingActivityHistoryListener
import com.intellij.vcs.commit.CommitModeManager.CommitModeListener
import com.intellij.vcs.commit.CommitModeManager.SettingsListener as CommitModeManagerSettingsListener
import com.intellij.vcs.commit.message.CommitMessageInspectionProfile.ProfileListener
import com.intellij.vcs.log.impl.VcsProjectLog.ProjectLogListener
import com.intellij.workspaceModel.ide.JpsProjectLoadedListener
import com.intellij.xdebugger.XDebuggerManagerListener
import com.intellij.xdebugger.breakpoints.XBreakpointListener
import com.intellij.xdebugger.impl.breakpoints.XDependentBreakpointListener
import com.intellij.xml.breadcrumbs.BreadcrumbsInitListener

internal class ESProblemsListener: ProblemsListener {

}

internal class ESEditorOptionsListener: EditorOptionsListener {

}

internal class ESReaderModeListener: ReaderModeListener {

}

internal class ESCodeVisionSettingsListener: CodeVisionSettingsListener {

}

internal class ESCompletionContributorListener: CompletionContributorListener {

}

internal class ESCompletionPhaseListener: CompletionPhaseListener {

}

internal class ESDaemonListener: DaemonListener {

}


internal class ESFileHighlightingSettingListener: FileHighlightingSettingListener {

}

internal class ESListener: Listener {

}

internal class ESEditorHintListener: EditorHintListener {

}

internal class ESExternalParameterInfoChangesProvider: ExternalParameterInfoChangesProvider {

}

internal class ESSettingsListener: SettingsListener {

}

internal class ESLookupManagerListener: LookupManagerListener {

}

internal class ESTemplateManagerListener: TemplateManagerListener {

}

internal class ESInspectListener: InspectListener {

}

internal class ESBatchUpdateListener: BatchUpdateListener {

}

internal class ESIdePerformanceListener: IdePerformanceListener {

}

internal class ESRunnablesListener: RunnablesListener {

}

internal class ESDvcsBranchManagerListener: DvcsBranchManagerListener {

}

internal class ESVcsRepositoryMappingListener: VcsRepositoryMappingListener {

}

internal class ESExecutionListener: ExecutionListener {

}

internal class ESExecutionTargetListener: ExecutionTargetListener {

}

internal class ESRunManagerListener: RunManagerListener {

}

internal class ESRunDashboardListener: RunDashboardListener {

}

internal class ESElevationSettingsListener: ElevationSettingsListener {

}

internal class ESRWSlotsConfigurationListener: RWSlotsConfigurationListener {

}

internal class ESServiceEventListener: ServiceEventListener {

}

internal class ESSMTRunnerEventsListener: SMTRunnerEventsListener {

}

internal class ESRunContentWithExecutorListener: RunContentWithExecutorListener {

}

internal class ESFacetManagerListener: FacetManagerListener {

}

internal class ESFeaturesRegistryListener: FeaturesRegistryListener {

}

internal class ESFindModelListener: FindModelListener {

}

internal class ESAppLifecycleListener: AppLifecycleListener {

}

internal class ESFrameStateListener: FrameStateListener {

}

internal class ESPowerSaveModeListener: PowerSaveModeListener {

}

internal class ESRecentProjectsChange: RecentProjectsChange {

}

internal class ESSaveAndSyncHandlerListener: SaveAndSyncHandlerListener {

}

internal class ESSETabSwitcherListener: SETabSwitcherListener {

}

internal class ESSearchListener: SearchListener {

}

internal class ESBookmarksListener: BookmarksListener {

}

internal class ESbookmarksBookmarksListener: bookmarksBookmarksListener {

}

internal class ESBatchFileChangeListener: BatchFileChangeListener {

}

internal class ESDataSharingSettingsChangeListener: DataSharingSettingsChangeListener {

}

internal class ESLightEditServiceListener: LightEditServiceListener {

}

internal class ESDynamicPluginListener: DynamicPluginListener {

}

internal class ESPluginRepositoryAuthListener: PluginRepositoryAuthListener {

}

internal class ESProjectViewListener: ProjectViewListener {

}

internal class ESTrustedProjectsListener: TrustedProjectsListener {

}

internal class ESLafManagerListener: LafManagerListener {

}

internal class ESUISettingsListener: UISettingsListener {

}

internal class ESVirtualFileAppearanceListener: VirtualFileAppearanceListener {

}

internal class ESCustomActionsListener: CustomActionsListener {

}

internal class ESComponentHighlightingListener: ComponentHighlightingListener {

}

internal class ESFileStructurePopupListener: FileStructurePopupListener {

}

internal class ESEventLogConfigOptionsListener: EventLogConfigOptionsListener {

}

internal class ESExternalResourceListener: ExternalResourceListener {

}

internal class ESEventListener: EventListener {

}

internal class ESNotifications: Notifications {

}

internal class ESAnActionListener: AnActionListener {

}

internal class ESToolbarActionsUpdatedListener: ToolbarActionsUpdatedListener {

}

internal class ESApplicationActivationListener: ApplicationActivationListener {

}

internal class ESCommandListener: CommandListener {

}

internal class ESLatencyListener: LatencyListener {

}

internal class ESEditorColorsListener: EditorColorsListener {

}

internal class ESEditorColorsManagerListener: EditorColorsManagerListener {

}

internal class ESExternalSystemProjectNotificationAwareListener: ExternalSystemProjectNotificationAwareListener {

}

internal class ESProjectDataImportListener: ProjectDataImportListener {

}

internal class ESFileDocumentManagerListener: FileDocumentManagerListener {

}

internal class ESBefore: Before {

}

internal class ESFileEditorManagerListener: FileEditorManagerListener {

}

internal class ESFileOpenedSyncListener: FileOpenedSyncListener {

}

internal class ESRecentPlacesListener: RecentPlacesListener {

}

internal class ESFileTypeListener: FileTypeListener {

}

internal class ESKeymapManagerListener: KeymapManagerListener {

}

internal class ESKeymapListener: KeymapListener {

}

internal class ESExternalUpdateRequest: ExternalUpdateRequest {

}

internal class ESProgressManagerListener: ProgressManagerListener {

}

internal class ESSuspenderListener: SuspenderListener {

}

internal class ESProgressWindowListener: ProgressWindowListener {

}

internal class ESBaseProjectDirectoriesListener: BaseProjectDirectoriesListener {

}

internal class ESDumbModeListener: DumbModeListener {

}

internal class ESModuleListener: ModuleListener {

}

internal class ESProjectCloseListener: ProjectCloseListener {

}

internal class ESProjectManagerListener: ProjectManagerListener {

}

internal class ESProjectLifecycleListener: ProjectLifecycleListener {

}

internal class ESProjectJdkTableListener: ProjectJdkTableListener {

}

internal class ESAdditionalLibraryRootsListener: AdditionalLibraryRootsListener {

}

internal class ESModuleRootListener: ModuleRootListener {

}

internal class ESRegistryValueListener: RegistryValueListener {

}

internal class ESBranchChangeListener: BranchChangeListener {

}

internal class ESBranchRenameListener: BranchRenameListener {

}

internal class ESFileStatusListener: FileStatusListener {

}

internal class ESPluginVcsMappingListener: PluginVcsMappingListener {

}

internal class ESVcsMappingListener: VcsMappingListener {

}

internal class ESChangeListAvailabilityListener: ChangeListAvailabilityListener {

}

internal class ESChangeListListener: ChangeListListener {

}

internal class ESChangesViewModifierListener: ChangesViewModifierListener {

}

internal class ESChangesViewWorkflowListener: ChangesViewWorkflowListener {

}

internal class ESLocalChangeListsLoadedListener: LocalChangeListsLoadedListener {

}

internal class ESVcsAnnotationRefresher: VcsAnnotationRefresher {

}

internal class ESVcsFreezingProcessListener: VcsFreezingProcessListener {

}

internal class ESVcsManagedFilesHolderListener: VcsManagedFilesHolderListener {

}

internal class ESCommittedChangesListener: CommittedChangesListener {

}

internal class ESCommittedChangesReloadListener: CommittedChangesReloadListener {

}

internal class ESDetailedNotification: DetailedNotification {

}

internal class ESNotification: Notification {

}

internal class ESShelveChangesManagerListener: ShelveChangesManagerListener {

}

internal class ESChangesViewContentManagerListener: ChangesViewContentManagerListener {

}

internal class ESVcsActivationListener: VcsActivationListener {

}

internal class ESLineStatusTrackerSettingListener: LineStatusTrackerSettingListener {

}

internal class ESVcsBaseContentProviderListener: VcsBaseContentProviderListener {

}

internal class ESUpdatedFilesListener: UpdatedFilesListener {

}

internal class ESVirtualFileManagerListener: VirtualFileManagerListener {

}

internal class ESEncodingManagerListener: EncodingManagerListener {

}

internal class ESBulkFileListener: BulkFileListener {

}

internal class ESVirtualFilePointerListener: VirtualFilePointerListener {

}

internal class ESStatusBarInfo: StatusBarInfo {

}

internal class ESToolWindowManagerListener: ToolWindowManagerListener {

}

internal class ESTitleInfoProviderListener: TitleInfoProviderListener {

}

internal class ESBalloonNotificationListener: BalloonNotificationListener {

}

internal class ESWelcomeScreenComponentListener: WelcomeScreenComponentListener {

}

internal class ESCloneProjectListener: CloneProjectListener {

}

internal class ESCourseDeletedListener: CourseDeletedListener {

}

internal class ESModuleAttachListener: ModuleAttachListener {

}

internal class ESProblemListener: ProblemListener {

}

internal class ESProfileChangeAdapter: ProfileChangeAdapter {

}

internal class ESPsiDocumentListener: PsiDocumentListener {

}

internal class ESCodeStyleManagerListener: CodeStyleManagerListener {

}

internal class ESCodeStyleSettingsListener: CodeStyleSettingsListener {

}

internal class ESAnyPsiChangeListener: AnyPsiChangeListener {

}

internal class ESPsiDocumentTransactionListener: PsiDocumentTransactionListener {

}

internal class ESIndexChangeListener: IndexChangeListener {

}

internal class ESPsiModificationTrackerListener: PsiModificationTrackerListener {

}

internal class ESRefactoringEventListener: RefactoringEventListener {

}

internal class ESRemoteMappingsListener: RemoteMappingsListener {

}

internal class ESRemoteServerListener: RemoteServerListener {

}

internal class ESServerConnectionListener: ServerConnectionListener {

}

internal class ESSpellCheckerEngineListener: SpellCheckerEngineListener {

}

internal class ESProjectTaskListener: ProjectTaskListener {

}

internal class ESDeferredIconListener: DeferredIconListener {

}

internal class ESToolWindowViewModelListener: ToolWindowViewModelListener {

}

internal class ESCommitModeListener: CommitModeListener {

}

internal class ESCommitModeManagerSettingsListener: CommitModeManagerSettingsListener {

}

internal class ESProfileListener: ProfileListener {

}

internal class ESProjectLogListener: ProjectLogListener {

}

internal class ESJpsProjectLoadedListener: JpsProjectLoadedListener {

}

internal class ESXDebuggerManagerListener: XDebuggerManagerListener {

}

internal class ESXDependentBreakpointListener: XDependentBreakpointListener {

}

internal class ESBreadcrumbsInitListener: BreadcrumbsInitListener {

}

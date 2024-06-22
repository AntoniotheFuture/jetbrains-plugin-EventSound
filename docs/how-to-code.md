# How to code

## Implement listeners

1. Gather all listener$Topic from [IntelliJ Platform](https://plugins.jetbrains.com/docs/intellij/intellij-platform-extension-point-list.html) and put them into scripts/intellij-topics.txt.
2. Run ```processFile``` task to generate listeners' code (scripts/listeners-code.txt) and xml declarations (scripts/listeners.xml).
3. Copy the code and declarations into corresponding files.
4. Remove or edit incompatible code.
5. Implement listener methods.
6. Build.
; GoenSheet.nsi
;
; This script is based on example1.nsi, but it remember the directory, 
; has uninstall support and (optionally) installs start menu shortcuts.
;
; It will install GoenSheet.nsi into a directory that the user selects,

LicenseText "License Agreement"
LicenseData "LICENSE.txt"
;--------------------------------

; The name of the installer
Name "GoenSheet"

; The file to write
OutFile "GoenSheetSetup.exe"

; The default installation directory
InstallDir $PROGRAMFILES\GoenSheet

; Registry key to check for directory (so if you install again, it will 
; overwrite the old one automatically)
InstallDirRegKey HKLM "Software\GoenSheet" "Install_Dir"

;--------------------------------

; Pages
page license
Page components
Page directory
Page instfiles

UninstPage uninstConfirm
UninstPage instfiles


;--------------------------------

; The stuff to install
Section "GoenSheet (required)"

  SectionIn RO
  
  ; Set output path to the installation directory.
  SetOutPath $INSTDIR
  
  ; Put file there
  File "goensheet.bat"
  File "goensheet.sh"
  File "GoenSheet.jar"
  File "README.txt"
  File "LICENSE.txt"
  File "logo.ico"
  File "fontsetting.conf" 
  File "example.xlg" 
 
  SetOutPath $INSTDIR

  
  ; Write the installation path into the registry
  WriteRegStr HKLM SOFTWARE\GoenSheet "Install_Dir" "$INSTDIR"
  
  ; Write the uninstall keys for Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GoenSheet" "DisplayName" "GoenSheet"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GoenSheet" "UninstallString" '"$INSTDIR\uninstall.exe"'
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GoenSheet" "NoModify" 1
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GoenSheet" "NoRepair" 1
  WriteUninstaller "uninstall.exe"
  
SectionEnd

; Optional section (can be disabled by the user)
Section "Start Menu Shortcuts"

  CreateDirectory "$SMPROGRAMS\GoenSheet"
  CreateShortCut "$SMPROGRAMS\GoenSheet\GoenSheet.lnk" "$SYSDIR\javaw.exe" "-jar GoenSheet.jar GoenSheet" "$INSTDIR\logo.ico"
  CreateShortCut "$SMPROGRAMS\GoenSheet\Readme.lnk" "$WINDIR\notepad.exe" "README.txt" "$WINDIR\notepad.exe"
  CreateShortCut "$SMPROGRAMS\GoenSheet\GoenSheet Directory.lnk" "$INSTDIR\" "" "$INSTDIR\" 0
  CreateShortCut "$SMPROGRAMS\GoenSheet\Uninstall.lnk" "$INSTDIR\uninstall.exe" "" "$INSTDIR\uninstall.exe" 0

  
SectionEnd

;--------------------------------

; Uninstaller

Section "Uninstall"
  
  ; Remove registry keys
  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GoenSheet"
  DeleteRegKey HKLM SOFTWARE\GoenSheet

  ; Remove files and uninstaller
  Delete "$INSTDIR\*.*"
  
  ; Remove shortcuts, if any
  Delete "$SMPROGRAMS\GoenSheet\*.*"

  ; Remove directories used
  RMDir "$SMPROGRAMS\GoenSheet"
  RMDir "$INSTDIR"

SectionEnd

# Render saved console output as PNG images; these are not desktop screenshots.
Add-Type -AssemblyName System.Drawing
$font = New-Object System.Drawing.Font('Consolas', 14)
$background = [System.Drawing.Color]::FromArgb(24, 24, 24)
try {
    foreach ($file in Get-ChildItem -LiteralPath (Join-Path $PSScriptRoot 'output') -Filter '*.txt') {
        $content = "Lab 4 output: $($file.BaseName)`r`n`r`n" + (Get-Content -LiteralPath $file.FullName -Raw)
        $bitmap = New-Object System.Drawing.Bitmap(1300, 500)
        $graphics = [System.Drawing.Graphics]::FromImage($bitmap)
        try {
            $graphics.Clear($background)
            $graphics.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit
            $graphics.DrawString($content, $font, [System.Drawing.Brushes]::White, 24, 24)
            $bitmap.Save([System.IO.Path]::ChangeExtension($file.FullName, '.png'),
                [System.Drawing.Imaging.ImageFormat]::Png)
        } finally {
            $graphics.Dispose()
            $bitmap.Dispose()
        }
    }
} finally {
    $font.Dispose()
}

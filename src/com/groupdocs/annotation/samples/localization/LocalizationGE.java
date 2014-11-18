package com.groupdocs.annotation.samples.localization;

import com.groupdocs.annotation.localization.ILocalization;
import com.groupdocs.annotation.localization.LocalizationKeys;

import java.util.HashMap;
import java.util.Map;

/**
 * Russian localization
 *
 * @author liosha (06.11.2014)
 */
public class LocalizationGE implements ILocalization {
    private static final Map<LocalizationKeys, String> keys2strings = new HashMap<LocalizationKeys, String>() {{
        put(LocalizationKeys.FirstPage, "Die erste Seite");
        put(LocalizationKeys.Size, "Размер");
        put(LocalizationKeys.Print, "Umfang");
        put(LocalizationKeys.SelectTool, "Arm");
        put(LocalizationKeys.TextReplacementTool, "Der Ersatz des Textes");
        put(LocalizationKeys.LoadingYourContent, "Die Auslastung des Inhalts");
        put(LocalizationKeys.Reply, "Antworten");
        put(LocalizationKeys.DOCWithChangesTrack, "DOC mit den Korrekturen");
        put(LocalizationKeys.FitHeight, "Nach der Höhe anzupassen");
        put(LocalizationKeys.SearchForward, "Die Suche vorwärts");
        put(LocalizationKeys.PointAnnotation, "Anmerkung");
        put(LocalizationKeys.DeleteAnnotation, "Die Inhaltsangabe zu entfernen");
        put(LocalizationKeys.NextPage, "Nächste Seite");
        put(LocalizationKeys.OriginalDocument, "Das Ausgangsdokument");
        put(LocalizationKeys.LastPage, "Letzte Seite");
        put(LocalizationKeys.RotateClockwise, "Die Wendung im Uhrzeigersinn");
        put(LocalizationKeys.RotateCounterClockwise, "Die Wendung gegen der Einstündige");
        put(LocalizationKeys.ResourceRedactionTool, "Das Verstecken der Ressourcen");
        put(LocalizationKeys.Summary, "Zusammenfassung");
        put(LocalizationKeys.AreaAnnotation, "Rechteck");
        put(LocalizationKeys.TextAnnotation, "Die Einblendung des Textes");
        put(LocalizationKeys.ParentFolder, "Die Elternmappe");
        put(LocalizationKeys.PointerTool, "Zeiger");
        put(LocalizationKeys.Modified, "Es ist geändert");
        put(LocalizationKeys.ViewMode, "Das Regime der Durchsicht");
        put(LocalizationKeys.PDFWithComments, "PDF mit den Kommentaren");
        put(LocalizationKeys.BookMode, "Das Buchregime");
        put(LocalizationKeys.FileName, "Der Name der Datei");
        put(LocalizationKeys.ScrollView, "Das Regime des Rollens");
        put(LocalizationKeys.UnderlineTextTool, "Unterstreichen");
        put(LocalizationKeys.TypewriterTool, "Schreibmaschinenwerkzeug");
        put(LocalizationKeys.Search, "Suche");
        put(LocalizationKeys.TextRedactionTool, "Das Verstecken des Textes");
        put(LocalizationKeys.PolylineAnnotation, "Bleistift");
        put(LocalizationKeys.SearchBackward, "Die Suche rückwärts");
        put(LocalizationKeys.ImportAnnotations, "Die Inhaltsangaben zu importieren");
        put(LocalizationKeys.Submit, "Abzusenden");
        put(LocalizationKeys.PDFWithoutComments, "PDF kommentarlos");
        put(LocalizationKeys.ZoomIn, "Vergrößern");
        put(LocalizationKeys.FitWidth, "Nach der Breite anzupassen");
        put(LocalizationKeys.Edit, "Editieren");
        put(LocalizationKeys.Undo, "Cancel");
        put(LocalizationKeys.OpenFile, "Die Datei zu öffnen");
        put(LocalizationKeys.Redo, "Zurückgeben");
        put(LocalizationKeys.ZoomOut, "Zu verringern");
        put(LocalizationKeys.CommentsForAnnotation, "Die Kommentare zur Inhaltsangabe");
        put(LocalizationKeys.Export, "Export");
        put(LocalizationKeys.DistanceTool, "Lineal");
        put(LocalizationKeys.PreviousPage, "Die vorhergehende Seite");
        put(LocalizationKeys.StrikeoutText, "Durchstreichen");
        put(LocalizationKeys.Of, "aus");
        put(LocalizationKeys.ZoomLevel, "Das Niveau der Untersetzung");
        put(LocalizationKeys.Page, "Seite");
        put(LocalizationKeys.WatermarkTool, "Das Wasserzeichen");
        put(LocalizationKeys.Download, "Downloaden");
        put(LocalizationKeys.Cancel, "Cancel");
        put(LocalizationKeys.Thumbs, "Die Miniaturen");
        put(LocalizationKeys.DOCWithComments, "DOC mit Anmerkungen");
    }};

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLocalizedString(LocalizationKeys localizationKeys) {
        return keys2strings.get(localizationKeys);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLocalizedRightPanelImage() {
        return null;
    }
}

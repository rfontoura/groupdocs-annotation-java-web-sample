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
        put(LocalizationKeys.Size, "Größe");
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
        put(LocalizationKeys.Delete, "löschen");
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
        put(LocalizationKeys.ImportingInternalDocumentAnnotations, "Importieren internen Dokument Anmerkungen");
        put(LocalizationKeys.TrialViewLimitMessage, "Ohne eine Evaluierungslizenz, nur 15 Seiten in 60 Minuten zu sehen. Bitte kontaktieren Sie das Vertriebsteam für eine kostenlose 30-Tage-Testlizenz.");
        put(LocalizationKeys.ExportingTheDocument, "Das Dokument exportieren...");
        put(LocalizationKeys.LessThanAMinuteAgo, "weniger als eine Minute");
        put(LocalizationKeys.Ago, "vor");
        put(LocalizationKeys.Hour, "stunde");
        put(LocalizationKeys.Hours, "stunden");
        put(LocalizationKeys.Minute, "minute");
        put(LocalizationKeys.Minutes, "minuten");
        put(LocalizationKeys.Day, "tag");
        put(LocalizationKeys.Days, "tage");
        put(LocalizationKeys.Week, "woche");
        put(LocalizationKeys.Weeks, "wochen");
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
        return "iVBORw0KGgoAAAANSUhEUgAAAC0AAAB3CAYAAACXD8kLAAAACXBIWXMAAAsSAAALEgHS3X78AAAKT2lDQ1BQaG90b3Nob3AgSUNDIHByb2ZpbGUAAHjanVNnVFPpFj333vRCS4iAlEtvUhUIIFJCi4AUkSYqIQkQSoghodkVUcERRUUEG8igiAOOjoCMFVEsDIoK2AfkIaKOg6OIisr74Xuja9a89+bN/rXXPues852zzwfACAyWSDNRNYAMqUIeEeCDx8TG4eQuQIEKJHAAEAizZCFz/SMBAPh+PDwrIsAHvgABeNMLCADATZvAMByH/w/qQplcAYCEAcB0kThLCIAUAEB6jkKmAEBGAYCdmCZTAKAEAGDLY2LjAFAtAGAnf+bTAICd+Jl7AQBblCEVAaCRACATZYhEAGg7AKzPVopFAFgwABRmS8Q5ANgtADBJV2ZIALC3AMDOEAuyAAgMADBRiIUpAAR7AGDIIyN4AISZABRG8lc88SuuEOcqAAB4mbI8uSQ5RYFbCC1xB1dXLh4ozkkXKxQ2YQJhmkAuwnmZGTKBNA/g88wAAKCRFRHgg/P9eM4Ors7ONo62Dl8t6r8G/yJiYuP+5c+rcEAAAOF0ftH+LC+zGoA7BoBt/qIl7gRoXgugdfeLZrIPQLUAoOnaV/Nw+H48PEWhkLnZ2eXk5NhKxEJbYcpXff5nwl/AV/1s+X48/Pf14L7iJIEyXYFHBPjgwsz0TKUcz5IJhGLc5o9H/LcL//wd0yLESWK5WCoU41EScY5EmozzMqUiiUKSKcUl0v9k4t8s+wM+3zUAsGo+AXuRLahdYwP2SycQWHTA4vcAAPK7b8HUKAgDgGiD4c93/+8//UegJQCAZkmScQAAXkQkLlTKsz/HCAAARKCBKrBBG/TBGCzABhzBBdzBC/xgNoRCJMTCQhBCCmSAHHJgKayCQiiGzbAdKmAv1EAdNMBRaIaTcA4uwlW4Dj1wD/phCJ7BKLyBCQRByAgTYSHaiAFiilgjjggXmYX4IcFIBBKLJCDJiBRRIkuRNUgxUopUIFVIHfI9cgI5h1xGupE7yAAygvyGvEcxlIGyUT3UDLVDuag3GoRGogvQZHQxmo8WoJvQcrQaPYw2oefQq2gP2o8+Q8cwwOgYBzPEbDAuxsNCsTgsCZNjy7EirAyrxhqwVqwDu4n1Y8+xdwQSgUXACTYEd0IgYR5BSFhMWE7YSKggHCQ0EdoJNwkDhFHCJyKTqEu0JroR+cQYYjIxh1hILCPWEo8TLxB7iEPENyQSiUMyJ7mQAkmxpFTSEtJG0m5SI+ksqZs0SBojk8naZGuyBzmULCAryIXkneTD5DPkG+Qh8lsKnWJAcaT4U+IoUspqShnlEOU05QZlmDJBVaOaUt2ooVQRNY9aQq2htlKvUYeoEzR1mjnNgxZJS6WtopXTGmgXaPdpr+h0uhHdlR5Ol9BX0svpR+iX6AP0dwwNhhWDx4hnKBmbGAcYZxl3GK+YTKYZ04sZx1QwNzHrmOeZD5lvVVgqtip8FZHKCpVKlSaVGyovVKmqpqreqgtV81XLVI+pXlN9rkZVM1PjqQnUlqtVqp1Q61MbU2epO6iHqmeob1Q/pH5Z/YkGWcNMw09DpFGgsV/jvMYgC2MZs3gsIWsNq4Z1gTXEJrHN2Xx2KruY/R27iz2qqaE5QzNKM1ezUvOUZj8H45hx+Jx0TgnnKKeX836K3hTvKeIpG6Y0TLkxZVxrqpaXllirSKtRq0frvTau7aedpr1Fu1n7gQ5Bx0onXCdHZ4/OBZ3nU9lT3acKpxZNPTr1ri6qa6UbobtEd79up+6Ynr5egJ5Mb6feeb3n+hx9L/1U/W36p/VHDFgGswwkBtsMzhg8xTVxbzwdL8fb8VFDXcNAQ6VhlWGX4YSRudE8o9VGjUYPjGnGXOMk423GbcajJgYmISZLTepN7ppSTbmmKaY7TDtMx83MzaLN1pk1mz0x1zLnm+eb15vft2BaeFostqi2uGVJsuRaplnutrxuhVo5WaVYVVpds0atna0l1rutu6cRp7lOk06rntZnw7Dxtsm2qbcZsOXYBtuutm22fWFnYhdnt8Wuw+6TvZN9un2N/T0HDYfZDqsdWh1+c7RyFDpWOt6azpzuP33F9JbpL2dYzxDP2DPjthPLKcRpnVOb00dnF2e5c4PziIuJS4LLLpc+Lpsbxt3IveRKdPVxXeF60vWdm7Obwu2o26/uNu5p7ofcn8w0nymeWTNz0MPIQ+BR5dE/C5+VMGvfrH5PQ0+BZ7XnIy9jL5FXrdewt6V3qvdh7xc+9j5yn+M+4zw33jLeWV/MN8C3yLfLT8Nvnl+F30N/I/9k/3r/0QCngCUBZwOJgUGBWwL7+Hp8Ib+OPzrbZfay2e1BjKC5QRVBj4KtguXBrSFoyOyQrSH355jOkc5pDoVQfujW0Adh5mGLw34MJ4WHhVeGP45wiFga0TGXNXfR3ENz30T6RJZE3ptnMU85ry1KNSo+qi5qPNo3ujS6P8YuZlnM1VidWElsSxw5LiquNm5svt/87fOH4p3iC+N7F5gvyF1weaHOwvSFpxapLhIsOpZATIhOOJTwQRAqqBaMJfITdyWOCnnCHcJnIi/RNtGI2ENcKh5O8kgqTXqS7JG8NXkkxTOlLOW5hCepkLxMDUzdmzqeFpp2IG0yPTq9MYOSkZBxQqohTZO2Z+pn5mZ2y6xlhbL+xW6Lty8elQfJa7OQrAVZLQq2QqboVFoo1yoHsmdlV2a/zYnKOZarnivN7cyzytuQN5zvn//tEsIS4ZK2pYZLVy0dWOa9rGo5sjxxedsK4xUFK4ZWBqw8uIq2Km3VT6vtV5eufr0mek1rgV7ByoLBtQFr6wtVCuWFfevc1+1dT1gvWd+1YfqGnRs+FYmKrhTbF5cVf9go3HjlG4dvyr+Z3JS0qavEuWTPZtJm6ebeLZ5bDpaql+aXDm4N2dq0Dd9WtO319kXbL5fNKNu7g7ZDuaO/PLi8ZafJzs07P1SkVPRU+lQ27tLdtWHX+G7R7ht7vPY07NXbW7z3/T7JvttVAVVN1WbVZftJ+7P3P66Jqun4lvttXa1ObXHtxwPSA/0HIw6217nU1R3SPVRSj9Yr60cOxx++/p3vdy0NNg1VjZzG4iNwRHnk6fcJ3/ceDTradox7rOEH0x92HWcdL2pCmvKaRptTmvtbYlu6T8w+0dbq3nr8R9sfD5w0PFl5SvNUyWna6YLTk2fyz4ydlZ19fi753GDborZ752PO32oPb++6EHTh0kX/i+c7vDvOXPK4dPKy2+UTV7hXmq86X23qdOo8/pPTT8e7nLuarrlca7nuer21e2b36RueN87d9L158Rb/1tWeOT3dvfN6b/fF9/XfFt1+cif9zsu72Xcn7q28T7xf9EDtQdlD3YfVP1v+3Njv3H9qwHeg89HcR/cGhYPP/pH1jw9DBY+Zj8uGDYbrnjg+OTniP3L96fynQ89kzyaeF/6i/suuFxYvfvjV69fO0ZjRoZfyl5O/bXyl/erA6xmv28bCxh6+yXgzMV70VvvtwXfcdx3vo98PT+R8IH8o/2j5sfVT0Kf7kxmTk/8EA5jz/GMzLdsAAAAgY0hSTQAAeiUAAICDAAD5/wAAgOkAAHUwAADqYAAAOpgAABdvkl/FRgAABrJJREFUeNrsm2FsU2UUhp9OsqWdlLrZiu7OpoxlAjaTbWqKQ9CwEMi2GHGRGERNIOHHFgxEDBpEoj+EiIkZRg0alR/GhbmQDYPKJC4KCwjT0YEgm5exTrF1pS22XSVb/VF6ZXPrym63exvvlyzputv22dfznfOe97S6nFU7o6h3hYFTwAngjYHGLR6ADNS99EA5sAk4k/vErkcBdCrf6dHrMrAgg/Ras4EX0g0a4IF0hDanIzQatAatQWvQGrQGrUFr0NO5ZkzFk9pMhoR/F30h9UDvXruYJaVzseWZE0P3eyjb+JHy0J9trqTCMT99wsNhzZWAm1o7aD56jq4+r7rD44F77pLe9vXvtSa8VqeW7OG7Gk76Wp1Opw7oT4514/YGsOQYk4BWUZ7+7MtTZOuz2LthWcLrolGVHEQAwTKLYDjC8ocWsHeCoA4EI2ze952y0DaTgceXlUi/33h7vDyN0tCiL0RTa0fS1wdCEVmvl25eHoBzygSTzWSYUIOoQns4rLm8vHYpBflmKf2VrduD6AvhsOZSv6kagLq3mmnvHVA+5VXZBRpeX4OjuGDMfN3eO8CPP/dhyzPzxBJ5GiVl0JufephsfRZNrR08u+PTMQ9m89FzACwpnas8dJVdwF4ocLj9LOvfa6XF6RrzuhanC7Hfgy3PLCveJw19Yzmec9dtsRDo6lV3u5WRChEx/eHxL/SJc7/Fsse91oSPeGZRrKsR+z2yNPWkoYeGh0dkhvbOHhbdV8DG5fZx477uycUAtJ3qVkdFtJkMtNWvJ1ufhfNC7CDaCwWaWjsotFqwFwop6Q8BZ0rLuM1k4KMXH5MA/5OrO3uoqz8kt91yTon2qLILLF1ow2jIkgTStz+K46bCm4WeEt+jq887ZmMbz82q8j32blhGecncCdsu1fgeB7etwlFckD6+R5VdkIA/bm6nse0sl/1hdfse8TIu9ntk9X7TKph+/e1KUnZBqip/SqBbnC7aO3uw5ZlHVMRoVMUxDVBXf4j9O57k6ZVlSTlSnxzrVh569iw9f4Ui2AsFXlm/YsKUpwro+k3Vki8t9nsSWEzQ3edRPjzikjMYjrDt3S/G3UUdkJGhY2g4qvxBNM3UA+D2BhK+7ak6lymBbj7eQzAcIVuflWTboAJo0Rdi/+EOLDlGdq9dnHCnh4aG1ZPyjIYsguEINRUlkiQdr+IEgoOaazrp8Gj6piPpk5ZWrqlOl5LSnrrOJSnH6Hr6EK+oQJraTAZOflCbfDjJ7Fz+vwN90ReibN2eCQVVw+trcHsD1GxvkPV6t+jnV7yaCnDf4LWEPy5/GGFmJo/cX0QmQ3zdeWmyL+We1vBobDsLwMryBcqX8WRXvNm15BiV8acns6ofjHXswXBEVkeesjw90Xj5TvMsyWY4/YtL+ewxWnskLGcXXNTVH1JHyktmYvv96YuyekNFtEeKloyJbVS5/3XS4ZGRkUEUiI6Cr7ILkk2mOt8jJjOjIw5joimAKnyPaHRkhNTXrcBeKBAMR3B7A9jyzLi9AYLhfwV//L7uSwr5HsOjdtlRXIDbG2Dlln0AnPyglu87ukd8euzgtlUU5JvZ+uER5ct4vNJ1nnch+kKIvhBub4BCq2XEde8fOI4lx8hLqxcpAz2WbXs1OCjdDoYj3DqqK4/PxstLVDDQH1Mc/RkYd3CvmGC68RDGTfWF8/Kl+873ugGorS6V7nNYcyXPT3HB1OJ0EQxHRky19jSfoqaihGerHRRZLfzu8UthIVcwTbpzGR3TwsxMXJe9/Onx4/KH8Q9eQ5iZyX1F+eTPzmHenDvJ1mch9nt4bucBfIPXJt25TJn20BHzbm6c3rrcfnY0/SBbe0wJdPyQXfSHpkKiyDNr4o6RzWSgtrqUJaWxaW3c8nV7A/T0eTh84hfe/sqZundR7k5X2QV21VVOOFp2XnDx3M4DsgefssJDp4NKu8A7L6wiWx+zeY/91MPP4h/4rheZu+8wUWS1SG2W2O+hZnuD7I9OzJBz1HbVVpKtz+Jw+1m2fnhkXJgqu8D2dRXY8szU162g8rXPlamIbz5djiXHiNjvYfXugwl3r8XpomZ7A8FwBEdxAVV2QRno0uvVr6WtK+k+8qujZwBYutCmDPQdubGDt+/ImaQf0yX+AUDRKPU3LdA2k0EKjZs5VM3HewCYfbtRmZ1Wcv3//Olkvm2hOmhLjjFpO0xx6Jv94sLopX2RQcseGrQGrUFr0Bq0Bq1Ba9AatGLLn47Qaaen/wbeTjfo5wcat5xPB+i/gDbgwYHGLe8C/DMA0J+4TjSS6HcAAAAASUVORK5CYII=";
    }
}

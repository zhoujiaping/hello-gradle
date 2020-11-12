//@Grab(group='com.craigburke.document', module='pdf', version='0.5.0')
//@Grab(group='com.craigburke.document', module='word', version='0.5.0')
import com.craigburke.document.builder.PdfDocumentBuilder
import com.craigburke.document.builder.WordDocumentBuilder
/**用脚本方式执行有异常：Caught: java.lang.ClassCastException: javax.imageio.metadata.IIOMetadataNode cannot be cast to org.w3c.dom.Element
 * 改用main方法执行就ok了
 */
def builders = [
        new PdfDocumentBuilder(new File('/example.pdf')),
        //new WordDocumentBuilder(new File('/example.docx'))
]

String[] COLORS = ['#FF0000', '#FF7F00', '#FFFF00', '#00FF00', '#0000FF', '#4B0082', '#8B00FF']

String GROOVY_IMAGE_URL = 'http://www.craigburke.com/images/posts/groovy-logo.png'
byte[] groovyImageData = new URL(GROOVY_IMAGE_URL).bytes

builders.each { builder ->
    builder.create {
        document(font: [family: 'Helvetica', size: 14.pt], margin: [top: 0.75.inches]) {

            heading1 "Groovy Document Builder v.0.5.0", font: [color: '#990000', size: 22.pt]

            heading2 "Paragraphs"

            paragraph {
                font.size = 42.pt
                "Hello World".eachWithIndex { letter, index ->
                    font.color = COLORS[ index % COLORS.size() ]
                    text letter
                    font.size--
                }
                lineBreak()
                text "Current font size is ${font.size}pt"
            }

            paragraph "Back to default font and aligned to the right", align: 'right'

            paragraph(margin: [left: 1.25.inches, right: 1.inch, top: 0.25.inches, bottom: 0.25.inches]) {
                font << [family: 'Times-Roman', bold: true, italic: true, color: '#333333']
                text "A paragraph with a different font and margins"
            }

            paragraph(align: 'center') {
                image(data: groovyImageData, width: 250.px, height: 125.px)
                lineBreak()
                text "Figure 1: Groovy Logo", font: [italic: true, size: 9.pt]
            }

            heading2 "Tables"

            table(width: 6.inches, padding: 4.px, border: [size: 3.px, color: '#990000']) {
                row {
                    cell('Left Aligned', width:1.5.inches, align:'left')
                    cell('Center Aligned', width:2.inches, align:'center')
                    cell(align:'right') {
                        text 'Right Aligned'
                    }
                }
            }
        }}
}


const userName = document.getElementById("name");
const subject = document.getElementById("sub");
const submitBtn = document.getElementById("submitBtn");

const { PDFDocument, rgb, degrees } = PDFLib;


const capitalize = (str, lower = false) =>
    (lower ? str.toLowerCase() : str).replace(/(?:^|\s|["'([{])+\S/g, (match) =>
        match.toUpperCase()
    );

submitBtn.addEventListener("click", () => {
    const val = capitalize(userName.value);
    const val1=capitalize(subject.value);

    //check if the text is empty or not
    if (val.trim() !== "" && userName.checkValidity()) {
        // console.log(val);
        generatePDF(val,val1);
    } else {
        userName.reportValidity();
    }
});

const generatePDF = async (name,sub) => {
    const existingPdfBytes = await fetch("./certificate.pdf").then((res) =>
        res.arrayBuffer()
    );

    // Load a PDFDocument from the existing PDF bytes
    const pdfDoc = await PDFDocument.load(existingPdfBytes);
    pdfDoc.registerFontkit(fontkit);

    //get font
    const fontBytes = await fetch("./Sanchez-Regular.ttf").then((res) =>
        res.arrayBuffer()
    );

    // Embed our custom font in the document
    const SanChezFont = await pdfDoc.embedFont(fontBytes);

    // Get the first page of the document
    const pages = pdfDoc.getPages();
    const firstPage = pages[0];
    const secondtext=pages[0];

    // Draw a string of text diagonally across the first page
    firstPage.drawText(name, {
        x: 300,
        y: 270,
        size: 58,
        font: SanChezFont,
        color: rgb(0.2, 0.84, 0.67),
    });
    secondtext.drawText(sub,{
        x: 360,
        y: 210,
        size: 20,
        font: SanChezFont,
        color: rgb(0.2, 0.84, 0.67),
    })

    // Serialize the PDFDocument to bytes (a Uint8Array)
    const pdfBytes = await pdfDoc.save();
    console.log("Done creating");

    // this was for creating uri and showing in iframe

    // const pdfDataUri = await pdfDoc.saveAsBase64({ dataUri: true });
    // document.getElementById("pdf").src = pdfDataUri;

    var file = new File(
        [pdfBytes],
        "Educare Certificate.pdf",
        {
            type: "application/pdf;charset=utf-8",
        }
    );
    saveAs(file);
};
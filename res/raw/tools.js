<script type="text/javascript">

function setCellContent(x, y, message)
{
    var cell = document.getElementById("c_" + x + "x" + y);

    if (cell && cell.firstChild)
    {
        cell.firstChild.nodeValue = message;
    }
}

function getCellContent(id)
{
    return document.getElementById(id).firstChild.nodeValue;
}
</script>

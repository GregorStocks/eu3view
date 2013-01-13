package editor.mapmode;

import editor.MapPanel;
import editor.ProvinceData.Province;
import editor.Text;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;

/**
 * A <code>MapMode</code> that paints all land provinces the color of the
 * country that owns them.
 * @author Michael Myers
 * @since 0.4pre1
 */
public class OwnerControllerMode extends ProvincePaintingMode {
    
    
    public OwnerControllerMode() {
        super();
    }
    
    public OwnerControllerMode(MapPanel panel) {
        super(panel);
    }
    
    protected void paintProvince(final Graphics2D g, int provId) {
        final String owner = mapPanel.getModel().getHistString(provId, "owner");
        final String controller = mapPanel.getModel().getHistString(provId, "controller");
        if (owner == null) {
            mapPanel.paintProvince(g, provId, Utilities.COLOR_NO_HIST);
        } else if(owner.equals("")) { //no owner
            mapPanel.paintProvince(g, provId, getCtryColor(owner));
        } else if(!(owner.equals(controller)) && controller != null && !controller.equals("")) {
            final Paint p = Utilities.createPaint(getCtryColor(owner), getCtryColor(controller));
            mapPanel.paintProvince(g, provId, p);
        } else {
            mapPanel.paintProvince(g, provId, getCtryColor(owner));
        }
    }
    
    protected void paintSeaZone(final Graphics2D g, int id) {
        // Don't paint sea zones.
        return;
    }
    
    protected Color getCtryColor(String country) {
        return Utilities.getCtryColor(country);
    }
    
    public String getTooltipExtraText(final Province current) {
        final int id = current.getId();
        if (!editor.Main.map.isLand(id))
            return "";
        
        final String ret = Text.getText(mapPanel.getModel().getHistString(id, "owner"));
        if (ret.length() == 0)
            return "";
        return "Owned by: " + ret;
    }
    
}
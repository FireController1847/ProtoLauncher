package net.protolauncher.ui.view.tab;

import javafx.scene.layout.StackPane;
import net.protolauncher.ui.view.AbstractView;

public class PlayTab extends AbstractView<StackPane> {

    // Constructor
    public PlayTab() {
        super(new StackPane());
        this.getLayout().setId("pt-layout");
    }

    // AbstractView Implementation
    @Override
    protected void construct() {

    }

    @Override
    protected void register() {

    }

}
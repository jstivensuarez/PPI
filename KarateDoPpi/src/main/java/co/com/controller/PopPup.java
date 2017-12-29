package co.com.controller;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PopPup extends SelectorComposer{
    private static final long serialVersionUID = 1L;
     
    @WireVariable
    Window modalDialog;
     
    @Command
    public void close() {
        modalDialog.detach();
    }
}

package co.com.interfaces;

import java.util.List;
import com.co.modelos.TipoDocumento;


public interface ITipoDocumentoBusiness {
	
	public void save(TipoDocumento t);
	
	public List<TipoDocumento> list();
	
	public void remove(TipoDocumento t);
	
}

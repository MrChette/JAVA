package Funcionalidades;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
	// Sobrescribimos el método que crea la cabecera
	protected void writeStreamHeader() throws IOException {
		// No hacer nada.
	}

	// Constructores
	public AppendableObjectOutputStream() throws IOException {
		super();
	}

	public AppendableObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
}

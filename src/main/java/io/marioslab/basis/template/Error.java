
package io.marioslab.basis.template;

import io.marioslab.basis.template.parsing.Span;
import io.marioslab.basis.template.parsing.TokenStream;

public class Error {
	public static void error (String message, TokenStream stream) {
		if (stream.hasMore())
			error(message, stream.consume().getSpan());
		else {
			String source = stream.getSource();
			if (source == null)
				error(message, new Span(" ", 0, 1));
			else
				error(message, new Span(source, source.length() - 1, source.length()));
		}
	}

	public static void error (String message, Span location) {
		// TODO generate line numbers and nice error message.
		throw new RuntimeException("Error: " + message + ", " + location.getText());
	}
}
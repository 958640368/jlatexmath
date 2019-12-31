package org.scilab.forge.jlatexmath.commands;

import org.scilab.forge.jlatexmath.Atom;
import org.scilab.forge.jlatexmath.ColorAtom;
import org.scilab.forge.jlatexmath.RowAtom;
import org.scilab.forge.jlatexmath.TeXParser;
import org.scilab.forge.jlatexmath.platform.graphics.Color;

public class CommandColor extends CommandStyle {

	Color fg;

	public CommandColor() {
		//
	}

	public CommandColor(RowAtom size, Color fg2) {
		this.size = size;
		this.fg = fg2;
	}

	@Override
	public boolean init(TeXParser tp) {
		fg = CommandDefinecolor.getColor(tp);
		return super.init(tp);
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new ColorAtom(a, null, fg);
	}

}

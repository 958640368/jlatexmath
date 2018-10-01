package org.scilab.forge.jlatexmath.commands;

import java.awt.Color;

import org.scilab.forge.jlatexmath.Atom;
import org.scilab.forge.jlatexmath.FBoxAtom;
import org.scilab.forge.jlatexmath.TeXParser;

public class CommandFColorBox extends Command1A {

	Color frame;
	Color bg;

	public CommandFColorBox() {
		//
	}

	public CommandFColorBox(Color frame2, Color bg2) {
		this.frame = frame2;
		this.bg = bg2;
	}

	@Override
	public boolean init(TeXParser tp) {
		frame = tp.getArgAsColor();
		bg = tp.getArgAsColor();
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new FBoxAtom(a, bg, frame);
	}

	@Override
	public Command duplicate() {
		return new CommandFColorBox(frame, bg);
	}

}

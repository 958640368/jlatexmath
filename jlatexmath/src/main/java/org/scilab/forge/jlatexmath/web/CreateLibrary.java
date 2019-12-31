/**
 * This file is part of the JLaTeXMath library - https://github.com/opencollab/jlatexmath/
 *
 * Copyright (C) 2019 JLaTeXMath developers and GeoGebra Gmbh
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * A copy of the GNU General Public License can be found in the file
 * LICENSE.txt provided with the source distribution of this program (see
 * the META-INF directory in the source jar). This license can also be
 * found on the GNU website at http://www.gnu.org/licenses/gpl.html.
 *
 * If you did not receive a copy of the GNU General Public License along
 * with this program, contact the lead developer, or write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 *
 * Linking this library statically or dynamically with other modules 
 * is making a combined work based on this library. Thus, the terms 
 * and conditions of the GNU General Public License cover the whole 
 * combination.
 * 
 * As a special exception, the copyright holders of this library give you 
 * permission to link this library with independent modules to produce 
 * an executable, regardless of the license terms of these independent 
 * modules, and to copy and distribute the resulting executable under terms 
 * of your choice, provided that you also meet, for each linked independent 
 * module, the terms and conditions of the license of that module. 
 * An independent module is a module which is not derived from or based 
 * on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obliged to do so. 
 * If you do not wish to do so, delete this exception statement from your 
 * version.
 * 
 */
package org.scilab.forge.jlatexmath.web;

import com.google.gwt.core.client.EntryPoint;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.web.font.opentype.Opentype;

public class CreateLibrary implements EntryPoint {

	private JlmLib library;
	private Opentype opentype;

	@Override
	public void onModuleLoad() {
		if (FactoryProvider.getInstance() == null) {
			FactoryProvider.setInstance(new FactoryProviderGWT());
		}
		library = new JlmLib();
		opentype = Opentype.INSTANCE;
		exportLibrary(library, opentype);
	}

	public static native void exportLibrary(JlmLib library,
			Opentype opentype) /*-{
		if ($wnd.jlmlib) {
			$wnd.console.log("JLM already installed");
			return;
		}
		var api = {};

		api.initWith = $entry(function(str) {
			library.@org.scilab.forge.jlatexmath.web.JlmLib::initWith(Ljava/lang/String;)(str);
		});

		api.SERIF = @org.scilab.forge.jlatexmath.TeXFont::SERIF;
		api.SANSSERIF = @org.scilab.forge.jlatexmath.TeXFont::SANSSERIF;
		api.BOLD = @org.scilab.forge.jlatexmath.TeXFont::BOLD;
		api.ITALIC = @org.scilab.forge.jlatexmath.TeXFont::ITALIC;
		api.ROMAN = @org.scilab.forge.jlatexmath.TeXFont::ROMAN;
		api.TYPEWRITER = @org.scilab.forge.jlatexmath.TeXFont::TYPEWRITER;

		api.drawLatex = $entry(function(opts) {
			//ctx, latex, size, style, x, y, fgColor, bgColor, cb
			if (!opts.context) {
				throw ("drawLatex(opts): opts.context must not be null");
			}
			if (!(typeof opts.latex == "string")) {
				throw ("drawLatex(opts): opts.latex must be of type string.");
			}
			var ctx = opts.context, latex = opts.latex, size = opts.size || 12, type = opts.type || 0;
			var x = opts.x || 0, y = opts.y || 0, insets = opts.insets || {
				top : 0,
				bottom : 0,
				left : 0,
				right : 0
			}, topInset = insets.top || 0, bottomInset = insets.bottom || 0, leftInset = insets.left || 0, rightInset = insets.right || 0, fgColor = opts.foregroundColor
					|| "#000000", bgColor = opts.backgroundColor, // undefined === invisible
			cb = opts.callback;

			return library.@org.scilab.forge.jlatexmath.web.JlmLib::drawLatex(Lcom/google/gwt/canvas/dom/client/Context2d;Ljava/lang/String;DIIIIIIILjava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(ctx, latex, size, type, x, y, topInset, leftInset, bottomInset, rightInset, fgColor, bgColor, cb);
		});

		api.setFontBaseUrl = $entry(function(url) {
			opentype.@org.scilab.forge.jlatexmath.web.font.opentype.Opentype::setFontBaseUrl(Ljava/lang/String;)(url);
		});
		if (typeof $wnd.jlmOnInit == "function") {
			$wnd.jlmOnInit(api);
		} else {
			$wnd.jlmlib = api;
		}
	}-*/;

}

/*
* Copyright (C) 2020 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package be.nabu.libs.tracer.api;

public interface IncomingWebRequestTrace extends Trace {
	/**
	 * 
	 * @param type This could be PREPROCESS or POSTPROCESS or REST or RESOURCE (static) or...
	 */
	public void setHandlerType(String type);
	public void setResponseCode(int code);
}

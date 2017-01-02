/*
 * Copyright (c) 2016 Villu Ruusmann
 *
 * This file is part of JPMML-XGBoost
 *
 * JPMML-XGBoost is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-XGBoost is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-XGBoost.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.xgboost;

import java.util.List;

import org.dmg.pmml.DataField;
import org.dmg.pmml.DataType;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.OpType;
import org.jpmml.converter.ContinuousLabel;
import org.jpmml.converter.Label;

abstract
public class Regression extends ObjFunction {

	@Override
	public LabelMap createLabelMap(FieldName targetField, List<String> targetCategories){

		if(targetCategories != null){
			throw new IllegalArgumentException();
		}

		DataField dataField = new DataField(targetField, OpType.CONTINUOUS, DataType.FLOAT);
		Label label = new ContinuousLabel(dataField);

		LabelMap labelMap = new LabelMap(dataField, label);

		return labelMap;
	}
}
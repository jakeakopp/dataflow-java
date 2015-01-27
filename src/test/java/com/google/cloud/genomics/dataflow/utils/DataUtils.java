/*
 * Copyright (C) 2014 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.genomics.dataflow.utils;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Arrays;
import java.util.List;

import com.google.api.services.genomics.model.Call;
import com.google.api.services.genomics.model.Variant;

public class DataUtils {

  public static Call makeCall(String name, Integer... alleles) {
    return new Call().setCallSetName(name).setGenotype(Arrays.asList(alleles));
  }

  public static Variant makeSimpleVariant(Call... calls) {
    return new Variant().setCalls(newArrayList(calls));
  }

  public static Variant makeVariant(String referenceName, long start, long end,
      String referenceBases, List<String> alternateBases, Call... calls) {
    Variant variant =
        new Variant().setReferenceName(referenceName).setStart(start).setEnd(end)
            .setReferenceBases(referenceBases).setAlternateBases(alternateBases);
    if (null != calls) {
      variant.setCalls(newArrayList(calls));
    }
    return variant;
  }

}

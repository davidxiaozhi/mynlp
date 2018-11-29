/*
 * Copyright 2018 mayabot.com authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mayabot.nlp.segment.tokenizer.xprocessor;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mayabot.nlp.segment.WordpathProcessor;
import com.mayabot.nlp.segment.common.BaseMynlpComponent;
import com.mayabot.nlp.segment.dictionary.Nature;
import com.mayabot.nlp.segment.perceptron.PerceptronPosService;
import com.mayabot.nlp.segment.wordnet.Vertex;
import com.mayabot.nlp.segment.wordnet.Wordpath;

import java.util.ArrayList;
import java.util.List;

/**
 * 感知机词性分析计算
 *
 * @author jimichan
 */
@Singleton
public class PosPerceptronProcessor extends BaseMynlpComponent implements WordpathProcessor {

    private final PerceptronPosService perceptronPosService;

    @Inject
    PosPerceptronProcessor(
            PerceptronPosService perceptronPosService
    ) {
        setOrder(ORDER_LASTEST);
        this.perceptronPosService = perceptronPosService;
    }

    @Override
    public Wordpath process(Wordpath wordPath) {
        ArrayList<Vertex> vertices = Lists.newArrayList(wordPath.iteratorVertex());
        List<Nature> posList = perceptronPosService.posFromVertex(vertices);

        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).setGuessNature(posList.get(i));
        }

        return wordPath;
    }
}
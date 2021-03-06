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
package com.mayabot.nlp.segment;

import com.mayabot.nlp.segment.core.CoreTokenizerBuilder;
import com.mayabot.nlp.segment.cws.CWSTokenizerBuilder;

/**
 * 各种版本的Tokenizer的工厂
 *
 * @author jimichan
 */
public class Tokenizers {

    /**
     * 默认配置的CoreTokenizer分词器。
     * 默认开启了【人名识别】【词性分析】【分词纠错】
     * 默认未开启 【自定义词典】【NER命名实体识别】
     *
     * @return MynlpTokenizer分词器实例，可多线程使用
     */
    public static MynlpTokenizer coreTokenizer() {
        return new CoreTokenizerBuilder().build();
    }

    /**
     * 默认配置的CoreTokenizer分词器构建器。
     * 默认开启了【人名识别】【词性分析】【分词纠错】
     * 默认未开启 【自定义词典】【NER命名实体识别】
     *
     * @return MynlpTokenizer分词器实例，可多线程使用
     */
    public static CoreTokenizerBuilder coreTokenizerBuilder() {
        return new CoreTokenizerBuilder();
    }

    /**
     * 默认配置的CoreTokenizer分词器。
     * 默认开启了【人名识别】【词性分析】【分词纠错】
     * 默认未开启 【自定义词典】【NER命名实体识别】
     *
     * @return MynlpTokenizer分词器实例，可多线程使用
     */
    public static MynlpTokenizer cwsTokenizer() {
        return cwsTokenizerBuilder().build();
    }

    /**
     * 默认配置的CwsTokenizer分词器构建器
     * CwsTokenizer是采用
     * 默认开启了【人名识别】【词性分析】【分词纠错】
     * 默认未开启 【自定义词典】【NER命名实体识别】
     *
     * @return MynlpTokenizer分词器实例，可多线程使用
     */
    public static CWSTokenizerBuilder cwsTokenizerBuilder() {
        return new CWSTokenizerBuilder();
    }

}

package com.mayabot.nlp.segment.cws

import com.mayabot.nlp.perceptron.solution.ner.NERPerceptron
import com.mayabot.nlp.perceptron.solution.ner.NERPerceptronTrainer
import com.mayabot.nlp.segment.Tokenizers
import com.mayabot.nlp.segment.plugins.ner.PerceptronNerService
import java.io.File


object NERPerceptronTest {

    @JvmStatic
    fun main(args: Array<String>) {
//        train()
        test()
    }

    fun train() {
        val trainer = NERPerceptronTrainer()

        val trainFile = File("data.work/ner")
        val evaluateFile = File("data.work/ner-test/ner_1.txt")

        val model = trainer.train(
                trainFile, evaluateFile,
                130, 1)

        model.save(File("data.work/ner.model"))
    }

    fun test() {
//        val evaluateFile = File("data/pku/199802.txt")

        val tokenizer = Tokenizers.coreTokenizer()
        val text = "这是陈建国的快递,来自上海万行信息科技有限公司的报告"

        val termList = tokenizer.parse(text).asWordList()


        val ner = NERPerceptron.load(File("data.work/ner.model"))


        println(termList)

        ner.decode(termList)

        println(PerceptronNerService.toNerComposite(termList).joinToString(separator = ","))

    }
}

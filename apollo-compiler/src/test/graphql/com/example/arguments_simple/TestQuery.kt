// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_simple

import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.InputFieldMarshaller
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMapper
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.internal.QueryDocumentMinifier
import com.apollographql.apollo.response.ScalarTypeAdapters
import com.apollographql.apollo.response.ScalarTypeAdapters.DEFAULT
import com.example.arguments_simple.fragment.HeroDetails
import com.example.arguments_simple.type.Episode
import java.io.IOException
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.jvm.Throws
import kotlin.jvm.Transient
import okio.BufferedSource

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class TestQuery(
  val episode: Input<Episode>,
  val includeName: Boolean,
  val friendsCount: Int,
  val listOfListOfStringArgs: List<List<String?>>
) : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      if (episode.defined) this["episode"] = episode.value
      this["IncludeName"] = includeName
      this["friendsCount"] = friendsCount
      this["listOfListOfStringArgs"] = listOfListOfStringArgs
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller { writer ->
      if (episode.defined) writer.writeString("episode", episode.value?.rawValue)
      writer.writeBoolean("IncludeName", includeName)
      writer.writeInt("friendsCount", friendsCount)
      writer.writeList("listOfListOfStringArgs") { listItemWriter ->
        listOfListOfStringArgs.forEach { value ->
          listItemWriter.writeList { listItemWriter ->
            value.forEach { value ->
              listItemWriter.writeString(value)
            }
          }
        }
      }
    }
  }

  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = variables
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  data class Hero(
    val __typename: String,
    /**
     * The name of the character
     */
    val name: String?,
    val fragments: Fragments
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeString(RESPONSE_FIELDS[0], __typename)
      it.writeString(RESPONSE_FIELDS[1], name)
      fragments.marshaller().marshal(it)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, true,
              listOf(ResponseField.Condition.booleanCondition("IncludeName", false))),
          ResponseField.forString("__typename", "__typename", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Hero {
        val __typename = reader.readString(RESPONSE_FIELDS[0])
        val name = reader.readString(RESPONSE_FIELDS[1])
        val fragments = reader.readConditional(RESPONSE_FIELDS[2]) { conditionalType, reader ->
          val heroDetails = HeroDetails(reader)
          Fragments(
            heroDetails = heroDetails
          )
        }

        return Hero(
          __typename = __typename,
          name = name,
          fragments = fragments
        )
      }
    }

    data class Fragments(
      val heroDetails: HeroDetails
    ) {
      fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
        heroDetails.marshaller().marshal(it)
      }
    }
  }

  data class HeroWithReview(
    val __typename: String,
    /**
     * What this human calls themselves
     */
    val name: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeString(RESPONSE_FIELDS[0], __typename)
      it.writeString(RESPONSE_FIELDS[1], name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): HeroWithReview {
        val __typename = reader.readString(RESPONSE_FIELDS[0])
        val name = reader.readString(RESPONSE_FIELDS[1])
        return HeroWithReview(
          __typename = __typename,
          name = name
        )
      }
    }
  }

  data class Data(
    val hero: Hero?,
    val heroWithReview: HeroWithReview?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeObject(RESPONSE_FIELDS[0], hero?.marshaller())
      it.writeObject(RESPONSE_FIELDS[1], heroWithReview?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("hero", "hero", mapOf<String, Any>(
            "episode" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "episode"),
            "listOfListOfStringArgs" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "listOfListOfStringArgs")), true, null),
          ResponseField.forObject("heroWithReview", "heroWithReview", mapOf<String, Any>(
            "episode" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "episode"),
            "review" to emptyMap<String, Any>()), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data {
        val hero = reader.readObject<Hero>(RESPONSE_FIELDS[0]) { reader ->
          Hero(reader)
        }

        val heroWithReview = reader.readObject<HeroWithReview>(RESPONSE_FIELDS[1]) { reader ->
          HeroWithReview(reader)
        }

        return Data(
          hero = hero,
          heroWithReview = heroWithReview
        )
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "89afe30dd0fa5ddce3d0b743d3adf68e55a48d0c11d10e495c0ec095949e6d04"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery(${'$'}episode: Episode, ${'$'}IncludeName: Boolean!, ${'$'}friendsCount: Int!, ${'$'}listOfListOfStringArgs: [[String]!]!) {
          |  hero(episode: ${'$'}episode, listOfListOfStringArgs: ${'$'}listOfListOfStringArgs) {
          |    __typename
          |    name @include(if: ${'$'}IncludeName)
          |    ...HeroDetails
          |  }
          |  heroWithReview(episode: ${'$'}episode, review: {}) {
          |    __typename
          |    name
          |  }
          |}
          |fragment HeroDetails on Character {
          |  __typename
          |  friendsConnection(first: ${'$'}friendsCount) {
          |    __typename
          |    totalCount
          |    edges {
          |      __typename
          |      node {
          |        __typename
          |        name @include(if: ${'$'}IncludeName)
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = OperationName { "TestQuery" }
  }
}

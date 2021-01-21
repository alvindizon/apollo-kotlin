// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.directives.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.directives.TestQuery
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("hero", "hero", null, true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var hero: TestQuery.Data.Hero? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> hero = readObject<TestQuery.Data.Hero>(RESPONSE_FIELDS[0]) { reader ->
            Hero.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        hero = hero
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        Hero.toResponse(writer, value.hero)
      }
    }
  }

  object Hero : ResponseAdapter<TestQuery.Data.Hero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("name", "name", null, true, listOf(
        ResponseField.Condition.booleanCondition("includeName", false)
      )),
      ResponseField.forObject("friendsConnection", "friendsConnection", null, true, listOf(
        ResponseField.Condition.booleanCondition("skipFriends", true)
      ))
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Hero {
      return reader.run {
        var name: String? = null
        var friendsConnection: TestQuery.Data.Hero.FriendsConnection? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> name = readString(RESPONSE_FIELDS[0])
            1 -> friendsConnection = readObject<TestQuery.Data.Hero.FriendsConnection>(RESPONSE_FIELDS[1]) { reader ->
              FriendsConnection.fromResponse(reader)
            }
            else -> break
          }
        }
        TestQuery.Data.Hero(
          name = name,
          friendsConnection = friendsConnection
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero) {
      writer.writeString(RESPONSE_FIELDS[0], value.name)
      if(value.friendsConnection == null) {
        writer.writeObject(RESPONSE_FIELDS[1], null)
      } else {
        writer.writeObject(RESPONSE_FIELDS[1]) { writer ->
          FriendsConnection.toResponse(writer, value.friendsConnection)
        }
      }
    }

    object FriendsConnection : ResponseAdapter<TestQuery.Data.Hero.FriendsConnection> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forInt("totalCount", "totalCount", null, true, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.FriendsConnection {
        return reader.run {
          var totalCount: Int? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> totalCount = readInt(RESPONSE_FIELDS[0])
              else -> break
            }
          }
          TestQuery.Data.Hero.FriendsConnection(
            totalCount = totalCount
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: TestQuery.Data.Hero.FriendsConnection) {
        writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
      }
    }
  }
}
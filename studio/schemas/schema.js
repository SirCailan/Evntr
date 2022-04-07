import createSchema from 'part:@sanity/base/schema-creator'
import schemaTypes from 'all:part:@sanity/base/schema-type'

import event from './documents/event.js'
import host from './documents/host.js'
import speaker from './documents/speaker.js'

export default createSchema({
  name: 'default',
  types: schemaTypes.concat([
    /* Your types here! */
    event,
    host,
    speaker
  ]),
})
